package com.example.mock_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallService {
    @Autowired
    IntroductionService introductionService;

    public String sayHi() {
        return introductionService.sayIt();
    }
}
