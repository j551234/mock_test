package com.example.mock_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MockBeanTest {
    @MockBean
    IntroductionService introductionService;
    @Autowired
    CallService callService;

    @Test
    void testBean() {
        when(introductionService.sayIt()).thenReturn("im mock oo");

        System.out.println(callService.sayHi());
    }
}
