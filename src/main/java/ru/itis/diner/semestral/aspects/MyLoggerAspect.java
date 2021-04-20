package ru.itis.diner.semestral.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Logger;

@Aspect
@Configurable
public class MyLoggerAspect {

    static Logger logger = Logger.getLogger(MyLoggerAspect.class.getName());

    @Pointcut("within(ru.itis.diner.semestral.controllers.*)")
    public void execute() {
    }

    @Pointcut("@annotation(ru.itis.diner.semestral.annotations.Logable)")
    public void logAnnotation() {
    }

    @Before("execute()")
    public void before(JoinPoint joinPoint) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("METHOD: " + joinPoint.getSignature().getName() + " User: " + name);
    }

}

