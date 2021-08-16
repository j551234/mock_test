package com.example.mock_test;

import com.example.mock_test.service.CallService;
import com.example.mock_test.service.IntroductionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MockBeanTest {
    @MockBean
    IntroductionService introductionService;
    @Autowired
    CallService callService;

    @Test
    void testBean() {
        when(introductionService.sayIt()).thenReturn("im mock object");
        System.out.println(callService.sayHi());
    }
}
