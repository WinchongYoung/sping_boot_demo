package com.controller;

import com.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCacheController {

    /**
     * Cacheable缓存测试
     * 缓存key = value + keyGenerator生成的key
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/getUser")
    @Cacheable(value = "SPRING_DEMO", keyGenerator = "keyGenerator")
    public String getUser(Long userId, String userName) {
        User user = new User("aa@126.com", "aa", "aa123456", "aa", "123", userId);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user.toString();
    }

}
