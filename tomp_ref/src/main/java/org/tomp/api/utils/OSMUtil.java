package org.tomp.api.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.client.ApiException;
import io.swagger.model.Coordinates;
import io.swagger.model.Place;

public class OSMUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	private OSMUtil() {
	}

	@SuppressWarnings("unchecked")
	public static List<Place> getOverpassObjects(String qlCondition, double[] bbox) throws ApiException, IOException {

		URL url = new URL("http://overpass-api.de/api/interpreter");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		Map<String, String> parameters = new HashMap<>();
		parameters.put("data", "[out:json];node(" + bbox[0] + "," + bbox[1] + "," + bbox[2] + "," + bbox[3] + ")["
				+ qlCondition + "];out;");

		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(getParamsString(parameters));
		out.flush();
		out.close();

		int status = con.getResponseCode();
		StringBuilder content = new StringBuilder();
		if (status == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
		}
		con.disconnect();
		HashMap<String, Object> map = mapper.readValue(content.toString(), HashMap.class);
		List<Object> elements = (List<Object>) map.get("elements");
		List<Place> places = new ArrayList<>();
		for (Object elementObject : elements) {
			HashMap<String, Object> element = (HashMap<String, Object>) elementObject;
			long id = Long.parseLong(element.get("id").toString());
			double lat = Double.parseDouble(element.get("lat").toString());
			double lon = Double.parseDouble(element.get("lon").toString());
			Place p = new Place();
			Coordinates coordinates = new Coordinates();
			coordinates.setLat((float) (lat));
			coordinates.setLng((float) (lon));
			HashMap<String, Object> extraInfo = new HashMap<>();
			extraInfo.put("osm_id", id);
			p.setExtraInfo(extraInfo);
			p.setCoordinates(coordinates);
			p.setStationId(String.valueOf(id));
			places.add(p);
		}
		return places;
	}

	private static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();

		for (Map.Entry<String, String> entry : params.entrySet()) {
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
			result.append("&");
		}

		String resultString = result.toString();
		return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
	}
}
