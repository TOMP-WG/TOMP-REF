package org.tomp.ready.generic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Conditional(TestCaseCondition.class)
public @interface TestCase {

	public String httpMethod() default "GET";
	
	public String endpoint() default "";
	
	public String[] version() default { "*.*.*" };

	public String[] modality() default { "*" };
	
	public String[] processIndicators() default {};
	
	public String[] scenarios() default {};
}
