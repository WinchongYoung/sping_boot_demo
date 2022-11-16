package com.observer;

import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServiceLoader implements ApplicationRunner, ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static Map<String, Observer> map;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ServiceLoader.applicationContext = applicationContext;
    }

    public static Map<String, Observer> getInterfaceImpls() {
        return map;
    }

    @Override
    public void run(ApplicationArguments args) {
        map = applicationContext.getBeansOfType(Observer.class);
    }

    public static void doNotify() {
        map.forEach((k, v) -> v.doSomeThing());
    }

}
