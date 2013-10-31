/**
 * 
 */
package com.example.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author apinto
 * 
 * Logs the method completion time for all methods annotated with {@link LogMethodTime}
 *
 */
@Component
@Aspect
public class LogMethodTimeUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogMethodTimeUtil.class);
	
	@Around("@annotation(com.example.util.LogMethodTime)")
	public Object logMethodExectutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object retVal = joinPoint.proceed();
		
		stopWatch.stop();
		LOGGER.info("Time to execute {} was {} millisec(s)", joinPoint.getSignature(), stopWatch.getTotalTimeMillis());
		
		return retVal;
	}

}
