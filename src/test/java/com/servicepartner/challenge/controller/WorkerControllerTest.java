package com.servicepartner.challenge.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure = false)
class WorkerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideSampleData")
    void getWorkerCount(String requestBody, String responseBody) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/servicepartner/workercount")
                .accept(MediaType.APPLICATION_JSON).content(requestBody)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(responseBody, result.getResponse().getContentAsString());
    }

    private static Stream<Arguments> provideSampleData(){
        return Stream.of(
                arguments("{ \"rooms\": [35, 21, 17, 28], \"senior\": 10, \"junior\": 6 }", "[{\"senior\":3,\"junior\":1},{\"senior\":1,\"junior\":2},{\"senior\":2,\"junior\":0},{\"senior\":1,\"junior\":3}]")
                ,arguments("{ \"rooms\": [24, 28], \"senior\": 11, \"junior\": 6 }","[{\"senior\":2,\"junior\":1},{\"senior\":2,\"junior\":1}]")
        );
    }
}