/**
 * 
 */
package com.example.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author adrain
 * 
 * Marks a method to be picked up by the LogMethodTimeUtil Aspect which logs the time it took for a method to complete.
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.METHOD)
public @interface LogMethodTime {

}
