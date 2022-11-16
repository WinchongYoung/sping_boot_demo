package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {
        "classpath:demo.yml",
        "classpath:demo2.yml",
}, factory = YamlPropertySourceFactory.class)
public class ConfigInit {

}