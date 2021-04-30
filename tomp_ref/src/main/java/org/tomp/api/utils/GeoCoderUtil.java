package org.tomp.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.GeoDecodeConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Address;
import io.swagger.model.Coordinates;
import io.swagger.model.GeojsonLine;
import io.swagger.model.GeojsonPoint;
import io.swagger.model.GeojsonPolygon;

@Component
public class GeoCoderUtil {

	private static final Logger log = LoggerFactory.getLogger(GeoCoderUtil.class);

	@Autowired
	GeoDecodeConfiguration geoDecodeConfiguration;
	ObjectMapper mapper = new ObjectMapper();

	@SuppressWarnings("unchecked")
	public GeojsonPolygon getRegionByName(String name) {
		String url = geoDecodeConfiguration.getEncodeUrl() + name;
		try (InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			HashMap<String, Object>[] results = mapper.readValue(jsonText, HashMap[].class);
			if (results.length > 0) {
				ArrayList<String> bb = (ArrayList<String>) results[0].get("boundingbox");
				GeojsonPolygon p = new GeojsonPolygon();
				addPoint(bb, 2, 0, p);
				addPoint(bb, 3, 0, p);
				addPoint(bb, 3, 1, p);
				addPoint(bb, 2, 1, p);
				addPoint(bb, 2, 0, p);
				return p;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public Address getPhysicalAddressByCoordinate(Coordinates coordinates) {
		Address address = new Address();
		return getPhysicalAddressByCoordinate(coordinates, address);
	}

	@SuppressWarnings("unchecked")
	public Address getPhysicalAddressByCoordinate(Coordinates coordinates, Address address) {
		String decodeUrl = geoDecodeConfiguration.getDecodeUrl();
		if (decodeUrl == null || decodeUrl.isEmpty()) {
			return null;
		}
		String url = decodeUrl + "&" + geoDecodeConfiguration.getLon() + "=" + coordinates.getLng() + "&"
				+ geoDecodeConfiguration.getLat() + "=" + coordinates.getLat();
		Map<String, Object> map = new HashMap<>();
		try (InputStream is = new URL(url).openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			map = mapper.readValue(jsonText, Map.class);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		String street = JsonUtil.getValue(geoDecodeConfiguration.getStreetAddress(), map);
		address.setStreetAddress(street);
		String area = JsonUtil.getValue(geoDecodeConfiguration.getArea(), map);
		address.setAreaReference(area);
		address.setPostalCode(JsonUtil.getValue(geoDecodeConfiguration.getPostalCode(), map));
		address.setCountry(JsonUtil.getValue(geoDecodeConfiguration.getCountry(), map));
		return address;
	}

	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private void addPoint(ArrayList<String> bb, int indexLng, int indexLat, GeojsonPolygon p) {
		if (p.isEmpty()) {
			p.add(new GeojsonLine());
		}
		GeojsonPoint c = new GeojsonPoint();
		c.add(BigDecimal.valueOf(Double.valueOf(bb.get(indexLng))));
		c.add(BigDecimal.valueOf(Double.valueOf(bb.get(indexLat))));
		p.get(0).add(c);
	}

	public boolean isActive() {
		return geoDecodeConfiguration.isActive();
	}

	public boolean isDecodingActive() {
		return geoDecodeConfiguration.isActive() && geoDecodeConfiguration.getDecodeUrl() != null
				&& !geoDecodeConfiguration.getDecodeUrl().isEmpty();
	}
}
