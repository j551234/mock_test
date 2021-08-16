package com.example.mock_test.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    String sayHello() {
        logger.info("hello");
        return "hello";

    }
}
