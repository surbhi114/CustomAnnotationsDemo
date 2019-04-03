package org.demo.customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // This annotation can be applied to fields of a class
public @interface JsonElement {
	public String key() default "";
}
