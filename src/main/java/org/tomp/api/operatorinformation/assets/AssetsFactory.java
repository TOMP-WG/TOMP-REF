package org.tomp.api.operatorinformation.assets;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;

public class AssetsFactory implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String assetClass = context.getEnvironment().getProperty("tomp.asset-class");
		AnnotationMetadataReadingVisitor visitor = (AnnotationMetadataReadingVisitor) metadata;
		return visitor.getClassName().equals(assetClass);
	}

}
