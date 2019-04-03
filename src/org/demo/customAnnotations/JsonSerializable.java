package org.demo.customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author i856147
 * This annotation has no methods, 
 * and thus serves as a simple marker to mark classes that can be serialized into JSON.
 *
 */

//meta-annotations
@Retention(RetentionPolicy.RUNTIME) //till what time this annotation should be present, runtime is the maximum
@Target(ElementType.TYPE) //to what all elements can this annotation be applied
public @interface JsonSerializable {

}
