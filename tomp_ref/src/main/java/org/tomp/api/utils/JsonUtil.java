package org.tomp.api.utils;

import java.util.Map;

public class JsonUtil {

	private JsonUtil() {

	}

	public static String getValue(String fields, Map<String, Object> map) {
		StringBuilder street = new StringBuilder();
		for (String field : fields.split("\\|")) {
			String value = getFieldValue(field, map);
			if (value != null) {
				street.append(value);
			} else if (field.contains(",") || field.contains(" ") || field.equals("-")) {
				street.append(field);
			}
		}

		return street.toString().trim();
	}

	@SuppressWarnings("unchecked")
	private static String getFieldValue(String field, Map<String, Object> map) {
		if (field.contains(".")) {
			String mapName = field.split("\\.")[0];
			Map<String, Object> submap = (Map<String, Object>) map.get(mapName);
			return getFieldValue(field.substring(field.indexOf('.') + 1), submap);
		}
		if (map.containsKey(field)) {
			return ((String) map.get(field)).trim();
		}
		return null;
	}
}
