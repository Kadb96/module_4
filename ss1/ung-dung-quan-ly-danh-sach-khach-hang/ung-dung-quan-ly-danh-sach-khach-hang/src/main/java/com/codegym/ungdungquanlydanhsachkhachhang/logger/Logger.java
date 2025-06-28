package com.codegym.ungdungquanlydanhsachkhachhang.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.ungdungquanlydanhsachkhachhang.service.CustomerService.findAll(..))", throwing = "e")
    public void logClass(Exception e) {
        System.out.printf("[CMS] ERROR: %n", e.getMessage());
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.ungdungquanlydanhsachkhachhang.service.CustomerService.*(..))", throwing = "e")
    public void logClass(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.printf("[CMS] ERROR: %s.%s%s: %s%n" + className, method, args, e.getMessage());
    }
}
