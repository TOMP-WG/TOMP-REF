package org.tomp.api.operatorinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.GbfsDataConfiguration;
import org.tomp.api.model.gbfs.Gbfs;
import org.tomp.api.model.gbfs.GbfsLanguageFeed;
import org.tomp.api.model.gbfs.GbfsLink;
import org.tomp.api.repository.GbfsRepository;
import org.tomp.api.utils.GeoCoderUtil;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Coordinates;
import io.swagger.model.Day;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.model.Time;
import io.swagger.model.TypeOfAsset;
import io.swagger.model.SystemHours.UserTypeEnum;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "gbfs", matchIfMissing = false)
public class GbfsOperatorInformation implements OperatorInformationProvider {

	private static final Logger log = LoggerFactory.getLogger(GbfsOperatorInformation.class);
	private static final ScheduledExecutorService SCHEDULER = new ScheduledThreadPoolExecutor(0);

	@Autowired
	GbfsDataConfiguration configuration;

	@Autowired
	GeoCoderUtil geocoderUtil;

	@Autowired
	GbfsRepository repository;

	private ObjectMapper mapper = new ObjectMapper();
	private Gbfs gbfs;
	private TimerTask task = new TimerTask() {
		public void run() {
			processAssetInformation();
		}
	};

	@PostConstruct
	public void readGbfsInformation() {
		configureMapper();

		processGbfsUrls();
		processOperatorInformation();
		processRegionInformation();
		processStationInformation();
		processAssetInformation();

		processOpeningHoursInformation();
		processOpeningDaysInformation();

		startTimer();
	}

	@SuppressWarnings("unchecked")
	private void processOpeningDaysInformation() {
		HashMap<String, Object> systemDays = getObjectFromUrl(getLink("system_calendar"), HashMap.class);
		if (systemDays != null) {
			ArrayList<HashMap<String, Object>> calendarData = (ArrayList<HashMap<String, Object>>) ((HashMap<String, Object>) systemDays
					.get("data")).get("calendars");
			processCalendars(calendarData);
		}
	}

	private void processCalendars(ArrayList<HashMap<String, Object>> calendarData) {
		repository.getSystemCalendar().clear();
		for (HashMap<String, Object> info : calendarData) {
			SystemCalendar calendar = new SystemCalendar();
			if (info.containsKey("start_year"))
				calendar.setStartYear(Integer.parseInt(info.get("start_year").toString()));
			if (info.containsKey("start_month"))
				calendar.setStartMonth(Integer.parseInt(info.get("start_month").toString()));
			if (info.containsKey("start_day"))
				calendar.setStartDay(Integer.parseInt(info.get("start_day").toString()));

			if (info.containsKey("end_year"))
				calendar.setEndYear(Integer.parseInt(info.get("end_year").toString()));
			if (info.containsKey("end_month"))
				calendar.setEndMonth(Integer.parseInt(info.get("end_month").toString()));
			if (info.containsKey("end_day"))
				calendar.setEndDay(Integer.parseInt(info.get("end_day").toString()));
			repository.getSystemCalendar().add(calendar);
		}
	}

	@SuppressWarnings("unchecked")
	private void processOpeningHoursInformation() {
		HashMap<String, Object> systemHours = getObjectFromUrl(getLink("system_hours"), HashMap.class);
		if (systemHours != null) {
			ArrayList<HashMap<String, Object>> hours = (ArrayList<HashMap<String, Object>>) ((HashMap<String, Object>) systemHours
					.get("data")).get("rental_hours");
			processSystemHours(hours);
		}
	}

	private void processSystemHours(ArrayList<HashMap<String, Object>> systemHourData) {
		repository.getSystemHours().clear();
		for (HashMap<String, Object> info : systemHourData) {
			SystemHours hours = new SystemHours();
			if (info.get("user_types").toString().contains("nonmember")) {
				hours.setUserType(UserTypeEnum.NON_MEMBERS);
			} else {
				hours.setUserType(UserTypeEnum.MEMBER);
			}
			hours.setDays(toDays(info.get("days")));
			hours.setStartTime(toTime(info.get("start_time").toString()));
			hours.setEndTime(toTime(info.get("end_time").toString()));
			repository.getSystemHours().add(hours);
		}
	}

	@SuppressWarnings("unchecked")
	private List<Day> toDays(Object dayList) {
		List<Day> days = new ArrayList<>();
		List<String> importDays = (List<String>) dayList;
		for (String importDay : importDays) {
			days.add(Day.fromValue(importDay.toUpperCase()));
		}
		return days;
	}

	private Time toTime(String time) {
		Time t = new Time();
		t.setTime(time);
		return t;
	}

	private void processGbfsUrls() {
		gbfs = getObjectFromUrl(configuration.getOpendataUrl(), Gbfs.class);
		repository.setLanguages(Arrays.asList(gbfs.getGbfsdata().keySet().toArray(new String[] {})));
	}

	private <T> T getObjectFromUrl(String url, Class<T> valueType) {
		try (InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			return mapper.readValue(jsonText, valueType);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private void processOperatorInformation() {
		HashMap<String, Object> systemInformation = getObjectFromUrl(getLink("system_information"), HashMap.class);
		repository.setOperatorInformation((HashMap<String, String>) systemInformation.get("data"));
	}

	@SuppressWarnings("unchecked")
	private void processStationInformation() {
		HashMap<String, Object> systemInformation = getObjectFromUrl(getLink("station_information"), HashMap.class);
		ArrayList<HashMap<String, Object>> stationData = (ArrayList<HashMap<String, Object>>) ((HashMap<String, Object>) systemInformation
				.get("data")).get("stations");
		processStations(stationData);
	}

	@SuppressWarnings("unchecked")
	private void processAssetInformation() {
		HashMap<String, Object> systemInformation = getObjectFromUrl(getLink("station_status"), HashMap.class);
		if (systemInformation != null) {
			repository.setBikesAtStations(
					(ArrayList<HashMap<String, Object>>) ((HashMap<String, Object>) systemInformation.get("data"))
							.get("stations"));
		}

		systemInformation = getObjectFromUrl(getLink("free_bike_status"), HashMap.class);
		if (systemInformation != null) {
			repository.setFreeBikes(
					(ArrayList<HashMap<String, Object>>) ((HashMap<String, Object>) systemInformation.get("data"))
							.get("bikes"));
		}
	}

	@SuppressWarnings("unchecked")
	private void processRegionInformation() {
		HashMap<String, Object> systemInformation = getObjectFromUrl(getLink("system_regions"), HashMap.class);
		ArrayList<HashMap<String, String>> regions = (ArrayList<HashMap<String, String>>) ((HashMap<String, Object>) systemInformation
				.get("data")).get("regions");
		geocodeRegions(regions);
	}

	private void configureMapper() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	private String getLink(String key) {
		GbfsLanguageFeed feed = null;
		if (gbfs.getGbfsdata().containsKey("en")) {
			feed = gbfs.getGbfsdata().get("en");
		} else {
			feed = gbfs.getGbfsdata().values().stream().findFirst().get();
		}

		for (GbfsLink link : feed.getFeeds()) {
			if (link.getName().equals(key)) {
				return link.getUrl();
			}
		}
		return null;
	}

	private void geocodeRegions(ArrayList<HashMap<String, String>> regionInformation) {
		if (regionInformation != null) {
			for (HashMap<String, String> region : regionInformation) {
				SystemRegion systemRegion = new SystemRegion();
				systemRegion.setRegionId(region.get("region_id"));
				systemRegion.setName(region.get("name"));
				if (geocoderUtil.isActive()) {
					systemRegion.setServiceArea(geocoderUtil.getRegionByName(region.get("name")));
				}
				repository.getRegions().add(systemRegion);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					log.error(e.getMessage());
				}
			}
		}
	}

	private void startTimer() {
		Timer timer = new Timer("GBFSTimer");
		long delay = configuration.getRefreshInMillis();
		timer.schedule(task, delay);
	}

	@Override
	public List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage) {
		return repository.getAssets();
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		return repository.getOperatorInformation();
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		return repository.getStations();
	}

	private void processStations(ArrayList<HashMap<String, Object>> stationData) {
		repository.getStations().clear();
		int delay = 0;
		for (HashMap<String, Object> info : stationData) {
			StationInformation station = new StationInformation();
			Coordinates coordinates = new Coordinates();
			coordinates.setLat(BigDecimal.valueOf(Double.valueOf(info.get("lat").toString())));
			coordinates.setLng(BigDecimal.valueOf(Double.valueOf(info.get("lon").toString())));
			station.setCoordinates(coordinates);
			station.setName(info.get("name").toString());
			station.setRegionId(info.get("region_id").toString());
			station.setStationId(info.get("station_id").toString());
			repository.getStations().add(station);
			delay += 1;
			if (geocoderUtil.isDecodingActive()) {
				CompletableFuture.runAsync(() -> geodecodeStation(station), delayedExecutor(delay, TimeUnit.SECONDS));
			}
		}
	}

	static Executor delayedExecutor(long delay, TimeUnit unit) {
		return delayedExecutor(delay, unit, ForkJoinPool.commonPool());
	}

	static Executor delayedExecutor(long delay, TimeUnit unit, Executor executor) {
		return r -> SCHEDULER.schedule(() -> executor.execute(r), delay, unit);
	}

	private void geodecodeStation(StationInformation station) {
		station.setPhysicalAddress(geocoderUtil.getPhysicalAddressByCoordinate(station.getCoordinates()));
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		return repository.getRegions();
	}

	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	@Override
	public List<SystemPricingPlan> getPricingPlans(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<SystemHours> getHours(String acceptLanguage) {
		return new ArrayList<>();
	}

	@Override
	public List<SystemCalendar> getCalendar(String acceptLanguage) {
		return new ArrayList<>();
	}
}
