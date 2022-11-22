package com.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.model.User;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class Seri {

    @Test
    public void test(){
        byte[] bytes = "{\"passWord\":\"kaka\",\"userName\":\"gaga\",\"userSex\":\"MAN\"}".getBytes(StandardCharsets.UTF_8);
        Object object = JSON.parseObject(new String(bytes, StandardCharsets.UTF_8), User.class);
        ParserConfig.getGlobalInstance().addAccept("com.model.User");
        System.out.println(object);
    }
}
