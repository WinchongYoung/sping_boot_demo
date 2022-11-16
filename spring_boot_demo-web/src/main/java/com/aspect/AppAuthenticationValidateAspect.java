package com.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AppAuthenticationValidateAspect {

    @Pointcut("@annotation(com.notation.OwnNotation)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void repeatSubmitIntercept(JoinPoint joinPoint) {
        //获取接口的参数
        Object[] o = joinPoint.getArgs();
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < parameterNames.length; i++) {
            System.out.println(parameterNames[i]);
        }
    }

    @After("pointCut()")
    public void doSomething() {
        System.out.println("over ....");
    }
}
