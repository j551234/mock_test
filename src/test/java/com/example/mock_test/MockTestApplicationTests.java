package com.example.mock_test;

import com.example.mock_test.model.Company;
import com.example.mock_test.model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

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
        assert (testman.getName().equals("james"));

        verify(testman, times(1)).getName();


    }

}
