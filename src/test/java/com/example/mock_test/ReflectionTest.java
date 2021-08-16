package com.example.mock_test;

import com.example.mock_test.model.Company;
import com.example.mock_test.model.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ReflectionTest {
    @Mock
    Person testman;
    @Test
    void testReflection() {
        Company company = new Company();
        when(testman.getName()).thenReturn("reflectMan");
        ReflectionTestUtils.setField(company,"owner",testman);
        System.out.println(company.getOwner().getName());
    }
}
