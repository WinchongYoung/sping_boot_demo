package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserConf {

    @Value("${user}")
    private String userName;

    public String getUserName() {
        return userName;
    }
}
