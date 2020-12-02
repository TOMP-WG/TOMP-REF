package org.tomp.ready.generic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TestCaseCondition implements Condition {

	private Map<String, Object> annotationAttributes;
	private ConditionContext context;

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		this.context = context;
		annotationAttributes = metadata.getAnnotationAttributes("org.tomp.ready.generic.TestCase");

		boolean versionOk = checkVersion();
		if (!versionOk) {
			return versionOk;
		}

		return checkModality();
	}

	private boolean checkModality() {
		List<String> modalities = Arrays.asList((String[]) annotationAttributes.get("modality"));
		if (modalities.contains("*")) {
			return true;
		}

		String modality = context.getEnvironment().getProperty("modality");
		return modalities.contains(modality);
	}

	private boolean checkVersion() {
		String version = context.getEnvironment().getProperty("version");

		List<String> versions = Arrays.asList((String[]) annotationAttributes.get("version"));

		for (String v : versions) {
			String minVersion = v.replace(".*", "");
			if (version.startsWith(minVersion)) {
				return true;
			}
		}

		return versions.contains(version);
	}

}
