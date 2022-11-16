package com.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileConfig {

    @Value("${file.server-name}")
    private String serverName;

    @Value("${file.mapper}")
    private String mapper;

    @Value("${file.images}")
    private String images;

    @Value("${file.video}")
    private String video;

}