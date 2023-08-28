package com.contact.controller;

import com.contact.BaseTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.MockMvc;

public class ContactControllerTest extends BaseTest {
    private MockMvc mockMvc;
//    @Order(1)
//    @Test
//    @SneakyThrows
//    public void createWithFields() {
//        mockMvc.perform(post("http://localhost:9090/contact?id=sd")
//                .contentType(APPLICATION_JSON)
//                .accept(APPLICATION_JSON));
//    }
}
