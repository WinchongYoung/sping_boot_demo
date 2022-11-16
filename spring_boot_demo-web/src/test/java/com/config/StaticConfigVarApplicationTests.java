package com.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class StaticConfigVarApplicationTests {

    @Autowired
    private FileConfig fileConfig;

    @Autowired
    private UserConf userConf;

    @Test
    void valueTest() {
        log.error("服务名：{}，映射：{}，存储图片的文件夹：{}，存放视频的文件夹：{}",fileConfig.getServerName(),fileConfig.getMapper(),fileConfig.getImages(),fileConfig.getVideo());
        log.error("图片目录：{}",fileConfig.getServerName()+fileConfig.getMapper()+fileConfig.getImages()+"123.jpg");
        log.error("视频目录：{}",fileConfig.getServerName()+fileConfig.getMapper()+fileConfig.getVideo()+"123.mp4");

        System.out.println(userConf.getUserName());
    }

}