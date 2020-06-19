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
import java.util.List;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.configuration.ParkingDataConfiguration;
import org.tomp.api.model.parking.LonLatLocation;
import org.tomp.api.model.parking.AccessPoints;
import org.tomp.api.model.parking.AreaGeometry;
import org.tomp.api.model.parking.DynamicParkingData;
import org.tomp.api.model.parking.ParkingData;
import org.tomp.api.model.parking.ParkingFacility;
import org.tomp.api.model.parking.ParkingFacilityDynamicInformation;
import org.tomp.api.model.parking.ParkingFacilityInformation;
import org.tomp.api.model.parking.Specification;
import org.tomp.api.model.parking.StaticParkingData;
import org.tomp.api.repository.ParkingRepository;
import org.tomp.api.utils.ObjectFromFileProvider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.AssetClass;
import io.swagger.model.Coordinates;
import io.swagger.model.Polygon;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemRegion;
import io.swagger.model.TypeOfAsset;

@Component
@ConditionalOnProperty(value = "tomp.providers.operatorinformation", havingValue = "parking", matchIfMissing = false)
public class ParkingOperatorInformationProvider implements OperatorInformationProvider {

	private static final Logger log = LoggerFactory.getLogger(ParkingOperatorInformationProvider.class);

	TimerTask task = new TimerTask() {
		public void run() {
			refreshDynamicData();
		}
	};

	@Autowired
	ParkingRepository repository;

	@Autowired
	ParkingDataConfiguration configuration;

	@Autowired
	ExternalConfiguration fileConfiguration;

	ObjectMapper mapper = new ObjectMapper();

	@PostConstruct
	public void postConstructor() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		readUrls();

		Timer timer = new Timer("Timer");

		long delay = configuration.getRefreshInMillis();
		timer.schedule(task, delay);
	}

	private void readUrls() {
		String url = configuration.getOpendataUrl();
		ParkingData parkingData = null;
		try (InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			parkingData = mapper.readValue(jsonText, ParkingData.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			return;
		}

		fetchInfo(parkingData);
	}

	private void fetchInfo(ParkingData parkingData) {
		List<String> uuids = Arrays.asList(configuration.getUuids());
		String namePart = configuration.getNameContains();

		// Arrays.asList(parkingData.getParkingFacilities()).stream().parallel().forEach(facility
		// -> {
		for (ParkingFacility facility : parkingData.getParkingFacilities()) {
			try {
				if (uuids.isEmpty() || uuids.contains(facility.getUuid())) {
					if (namePart == null || facility.getName().indexOf(namePart) != -1) {
						if (facility.getGeoLocation() != null) {
							SystemRegion e = new SystemRegion();
							e.setName(facility.getName());
							e.setRegionId(facility.getUuid());
							e.setServiceArea(toPolygon(facility.getGeoLocation()));
							repository.getRegions().add(e);
						}
						registrateStaticInfo(facility.getStaticDataUrl());
						String dynamicDataUrl = facility.getDynamicDataUrl();
						if (dynamicDataUrl != null) {
							registrateDynamicInfo(dynamicDataUrl);
							repository.getDynamicUrls().put(facility.getUuid(), dynamicDataUrl);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void registrateDynamicInfo(String url) {
		if (url != null) {
			DynamicParkingData parkingData = null;
			try (InputStream is = new URL(url).openStream()) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
				String jsonText = readAll(rd);
				parkingData = mapper.readValue(jsonText, DynamicParkingData.class);
			} catch (Exception e) {
				log.error(e.getMessage());
				return;
			}
			if (parkingData != null) {
				repository.getDynamicData().put(parkingData.getParkingFacilityDynamicInformation().getIdentifier(),
						parkingData.getParkingFacilityDynamicInformation());
			}
		}
	}

	private void registrateStaticInfo(String url) {
		StaticParkingData parkingData = null;
		try (InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			parkingData = mapper.readValue(jsonText, StaticParkingData.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			return;
		}
		ParkingFacilityInformation information = parkingData.getInformation();
		repository.getStaticData().put(information.getIdentifier(), information);
		repository.getRegions().addAll(convertToRegion(information));
		repository.getStations().add(convertToStation(information));
		log.info("Registrated {}", url);
	}

	private StationInformation convertToStation(ParkingFacilityInformation information) {
		StationInformation station = new StationInformation();
		station.setName(information.getName());
		station.setStationId(information.getIdentifier());
		station.setRegionId(information.getIdentifier());
		return station;
	}

	private List<SystemRegion> convertToRegion(ParkingFacilityInformation information) {
		List<SystemRegion> regionList = new ArrayList<>();
		if (information.getAccessPoints() != null && information.getAccessPoints().length > 0) {
			for (AccessPoints point : information.getAccessPoints()) {
				if (point != null && point.getAccessPointLocation() != null) {
					for (LonLatLocation location : point.getAccessPointLocation()) {
						SystemRegion region = new SystemRegion();
						region.setName(information.getName());
						region.setRegionId(information.getIdentifier());
						region.setServiceArea(toPolygon(location));
						regionList.add(region);
						break;
					}
				}
			}
		} else {
			for (Specification area : information.getSpecifications()) {
				if (area != null) {
					SystemRegion region = new SystemRegion();
					region.setName(information.getName());
					region.setRegionId(information.getIdentifier());
					AreaGeometry areaGeometry = area.getAreaGeometry();
					if (areaGeometry != null && areaGeometry.getType().equals("Polygon")) {
						region.setServiceArea(toServiceArea(areaGeometry.getPolygon()));
					}
					// TODO MultiPolygon
					regionList.add(region);
				}
			}
		}
		return regionList;
	}

	private Polygon toPolygon(LonLatLocation location) {
		Polygon p = new Polygon();
		BigDecimal r = BigDecimal.valueOf(configuration.getR());
		Coordinates pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().subtract(r));
		pointsItem.setLng(location.getLongitude().subtract(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().subtract(r));
		pointsItem.setLng(location.getLongitude().add(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().add(r));
		pointsItem.setLng(location.getLongitude().add(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().add(r));
		pointsItem.setLng(location.getLongitude().subtract(r));
		p.addPointsItem(pointsItem);

		pointsItem = new Coordinates();
		pointsItem.setLat(location.getLatitude().subtract(r));
		pointsItem.setLng(location.getLongitude().subtract(r));
		p.addPointsItem(pointsItem);
		return p;
	}

	private Polygon toServiceArea(BigDecimal[][][] area) {
		Polygon p = new Polygon();
		p.setPoints(toCoordinates(area));
		return p;
	}

	private List<Coordinates> toCoordinates(BigDecimal[][][] polygon) {
		List<Coordinates> coords = new ArrayList<>();
		if (polygon != null) {
			for (BigDecimal[][] b : polygon) {
				if (b != null) {
					for (BigDecimal[] c : b) {
						Coordinates e = new Coordinates();
						e.setLng(c[0]);
						e.setLat(c[1]);
						coords.add(e);
					}
					if (coords.get(0) != coords.get(coords.size() - 1)) {
						coords.add(coords.get(0));
					}
				}
			}
		}
		return coords;
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
	public List<TypeOfAsset> getAvailableAssetTypes(String acceptLanguage) {
		List<TypeOfAsset> assets = new ArrayList<>();
		for (ParkingFacilityDynamicInformation data : repository.getDynamicData().values()) {
			assets.add(convertToTypeOfAsset(data));
		}

		return assets;
	}

	private TypeOfAsset convertToTypeOfAsset(ParkingFacilityDynamicInformation data) {
		TypeOfAsset type = new TypeOfAsset();
		type.setName(data.getName());
		type.setAssetClass(AssetClass.PARKING);
		type.setAmountAvailable(BigDecimal.valueOf(data.getFacilityActualStatus().getVacantSpaces()));
		return type;
	}

	@Override
	public List<StationInformation> getStations(String acceptLanguage) {
		return repository.getStations();
	}

	@Override
	public List<SystemRegion> getRegions(String acceptLanguage) {
		return repository.getRegions();
	}

	@Override
	public SystemInformation getOperatorInformation(String acceptLanguage) {
		ObjectFromFileProvider<SystemInformation> provider = new ObjectFromFileProvider<>();
		return provider.getObject(acceptLanguage, SystemInformation.class,
				fileConfiguration.getSystemInformationFile());
	}

	void refreshDynamicData() {
		for (Entry<String, String> entry : repository.getDynamicUrls().entrySet()) {
			registrateDynamicInfo(entry.getValue());
		}
	}
}
