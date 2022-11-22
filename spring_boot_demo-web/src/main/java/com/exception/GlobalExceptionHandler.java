package com.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 文件上传大小超过限制异常处理
     *
     * @param e
     */
    @ExceptionHandler(MultipartException.class)
    public void handleError1(MultipartException e) {
        e.printStackTrace();
        System.out.println("file size is oversize the limit");
    }
}