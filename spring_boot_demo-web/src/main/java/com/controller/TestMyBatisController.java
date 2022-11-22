package com.controller;

import com.mapper.User2Mapper;
import com.mapper.UserMapper;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestMyBatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private User2Mapper userMapper2;

    @GetMapping("/testMyBatis")
    public List<User> testMyBatis() {
        List<User> all = userMapper.getAll();
        return all;
    }

    @GetMapping("/testMyBatisCount")
    public Long testMyBatisCount() {
        return userMapper.count();
    }

    @GetMapping("/testMyBatisGetById")
    public User testMyBatisGetById() {
        return userMapper2.getOne(1L);
    }

}
