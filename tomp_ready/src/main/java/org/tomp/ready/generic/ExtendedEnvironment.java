package org.tomp.ready.generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.core.env.Environment;

public class ExtendedEnvironment implements Environment {

	private static final String VERSION_LABEL = "version";
	private Environment environment;
	private Map<String, String> items = new HashMap<>();

	public ExtendedEnvironment(Environment environment, String version) {
		this.environment = environment;
		this.items.put(VERSION_LABEL, version);
	}

	public void addValue(String key, String value) {
		items.put(key, value);
	}

	@Override
	public boolean containsProperty(String key) {
		return items.containsKey(key) || environment.containsProperty(key);
	}

	@Override
	public String getProperty(String key) {
		if (items.containsKey(key))
			return items.get(key);
		return environment.getProperty(key);
	}

	@Override
	public String getProperty(String key, String defaultValue) {
		if (items.containsKey(key))
			return items.get(key);
		return environment.getProperty(key, defaultValue);
	}

	@Override
	public <T> T getProperty(String key, Class<T> targetType) {
		return environment.getProperty(key, targetType);
	}

	@Override
	public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
		return environment.getProperty(key, targetType, defaultValue);
	}

	@SuppressWarnings("deprecation")
	@Override
	public <T> Class<T> getPropertyAsClass(String key, Class<T> targetType) {
		return environment.getPropertyAsClass(key, targetType);
	}

	@Override
	public String getRequiredProperty(String key) throws IllegalStateException {
		return environment.getRequiredProperty(key);
	}

	@Override
	public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
		return environment.getRequiredProperty(key, targetType);
	}

	@Override
	public String resolvePlaceholders(String text) {
		for (Entry<String, String> entry : items.entrySet()) {
			text = text.replace("${" + entry.getKey() + "}", entry.getValue());
		}
		return environment.resolvePlaceholders(text);
	}

	@Override
	public String resolveRequiredPlaceholders(String text) {
		for (Entry<String, String> entry : items.entrySet()) {
			text = text.replace("${" + entry.getKey() + "}", entry.getValue());
		}
		return environment.resolveRequiredPlaceholders(text);
	}

	@Override
	public String[] getActiveProfiles() {
		return environment.getActiveProfiles();
	}

	@Override
	public String[] getDefaultProfiles() {
		return environment.getDefaultProfiles();
	}

	@Override
	public boolean acceptsProfiles(String... profiles) {
		return environment.acceptsProfiles(profiles);
	}

}
