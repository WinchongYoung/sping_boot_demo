package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.enums.UserSexEnum;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/testRedis")
    public void testRedis(Integer value) {
        stringRedisTemplate.opsForValue().set("aaa", value.toString());
    }

    @GetMapping("/testRedis2")
    public String testRedis2() {
        return stringRedisTemplate.opsForValue().get("aaa");
    }

    /**
     * 存对象
     */
    @GetMapping("/testRedis3")
    public void testRedis3() {
        User user = new User("gaga", "kaka", UserSexEnum.MAN);
        redisTemplate.opsForValue().set("aaa", user);
    }

    /**
     * 取对象
     * @return
     */
    @GetMapping("/testRedis4")
    public User testRedis4() {
        return JSON.toJavaObject((JSONObject) redisTemplate.opsForValue().get("aaa"), User.class);
    }

}
