//package com.contact.controller;
//
//import com.contact.BaseTest;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static util.CodeUtil.CONTACT_SERVICE;
//
//public class ContactControllerTest extends BaseTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Order(1)
//    @Test
//    @SneakyThrows
//    public void getWithCorrectId() {
//        mockMvc.perform(get("http://localhost:9090/contact?id=64e8478e568a15371f3905fa")
//                .contentType(APPLICATION_JSON)
//                .accept(APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Order(2)
//    @Test
//    @SneakyThrows
//    public void getWithWrongId() {
//        mockMvc.perform(get("http://localhost:9090/contact?id=64e")
//                        .contentType(APPLICATION_JSON)
//                        .accept(APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//}
