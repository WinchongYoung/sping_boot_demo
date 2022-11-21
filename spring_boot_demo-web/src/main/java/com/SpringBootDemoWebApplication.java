package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.*"})
// 开启redis缓存
@EnableCaching
public class SpringBootDemoWebApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoWebApplication.class, args);
        logger.info("spring demo start successfully");
    }
}
