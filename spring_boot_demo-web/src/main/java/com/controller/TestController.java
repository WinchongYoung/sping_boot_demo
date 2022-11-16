package com.controller;

import com.config.UserConf;
import com.entity.ReturnResult;
import com.notation.OwnNotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import com.observer.ServiceLoader;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    UserConf userConf;


    @GetMapping("/getTest")
    public String getTest(HttpServletRequest request) {
        String age = request.getParameter("age");
        System.out.println("age=" + age);
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String age1 = request.getParameter("age");
            System.out.println("age1=" + age1);
        }).start();
        return "success";
    }

    @GetMapping("/getImpl")
    public String getImpl(HttpServletRequest request) {
        ServiceLoader.doNotify();
        return "";
    }

    @GetMapping("/getHello")
    public String getHello(HttpServletRequest request) {
        return request.getParameter("field_name");
    }

    @GetMapping("/testConf")
    public String testConf(HttpServletRequest request) {
        String userName = userConf.getUserName();
        System.out.println(userName);
        System.out.println("666");
        return userName;
    }

    @GetMapping("/testAnnotation")
    @OwnNotation
    public ReturnResult testAnnotation(HttpServletRequest request) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setErr(0);
        returnResult.setRet(1);
        returnResult.setData(new HashMap<>(0));
        return returnResult;
    }

    /**
     * ModelAttribute 注解：在调用Controller方法前调用该方法
     * 应用场景：BaseController
     */
    @ModelAttribute
    public void attribute(){
        System.out.println("I'm a method decorated by ModelAttribute annotation");
    }

}
