package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class TestFileUpload {

    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "D://tmp//";

    /**
     * 测试文件上传
     * 文件大小限制配置 application.properties
     * 测试参考 https://blog.csdn.net/weixin_45739720/article/details/103720004
     *
     * @param file
     * @return
     */
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path dir = Paths.get(UPLOADED_FOLDER);
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            // Create parent dir if not exists
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            Files.write(path, bytes);
            return "You successfully uploaded:" + file.getOriginalFilename();
        } catch (IOException e) {
            e.printStackTrace();
            return "Server throw IOException";
        }
    }

}
