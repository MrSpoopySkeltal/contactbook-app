package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.controller..*(..)) || execution(* com.service..*(..)) || execution(* com.repository..*(..))")
    public void applicationPackagePointcut() {
        // Matches methods in controller, service, and repository packages
    }

    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("ENTER: {}.{}()", className, methodName);
        try {
            Object result = joinPoint.proceed();
            logger.info("EXIT: {}.{}()", className, methodName);
            return result;
        } catch (Exception e) {
            logger.error("EXCEPTION in {}.{}() - {}", className, methodName, e.getMessage(), e);
            throw e;
        }
    }
}
