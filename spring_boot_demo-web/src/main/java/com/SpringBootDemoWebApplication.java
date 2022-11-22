package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.*"})
// 开启redis缓存
@EnableCaching
// mapper
@MapperScan("com.mapper")
// 开启定时任务
@EnableScheduling
public class SpringBootDemoWebApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoWebApplication.class, args);
        logger.info("spring demo start successfully");
    }
}
