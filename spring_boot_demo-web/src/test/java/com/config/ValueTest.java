package com.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValueTest {

    @Value("${user.name}")
    private String userName;


    @Test
    public void test() {
        System.out.println(userName);
    }
}