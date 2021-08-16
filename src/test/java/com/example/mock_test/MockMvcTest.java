package com.example.mock_test;

import com.example.mock_test.service.CallService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest
public class MockMvcTest {
    @MockBean
    CallService callService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testHello() throws Exception {
        when(callService.sayHi()).thenReturn("Hello, spring");

        this.mockMvc.perform(MockMvcRequestBuilders.get("/sayIt"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, spring"));
    }

}
