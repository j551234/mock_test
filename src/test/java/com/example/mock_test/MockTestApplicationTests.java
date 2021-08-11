package com.example.mock_test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class MockTestApplicationTests {
    @Mock
    Person testman;
    @InjectMocks
    Company testcom;

    @Test
    void contextLoads() {
    }

    @Test
    void testMock() {
        when(testman.getName()).thenReturn("james");
        System.out.println(testcom.getOwner().getName());
    }

}
