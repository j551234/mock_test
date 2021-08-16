package com.example.mock_test.controller;


import com.example.mock_test.service.CallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CallService callService;

    @RequestMapping("/")
    String sayHello() {
        logger.info("hello");
        return "hello";

    }


    @RequestMapping("/sayIt")
    String saySomething() {
        return callService.sayHi();
    }

}
