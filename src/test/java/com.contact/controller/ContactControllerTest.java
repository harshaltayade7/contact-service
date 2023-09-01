package com.contact.controller;

import com.contact.BaseTest;
import com.contact.exceptions.ItemNotFoundException;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import com.contact.util.CodeUtil;
import com.contact.util.FactoryUtil;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.contact.util.CodeUtil.CONTACT_SERVICE;
import com.contact.util.FactoryUtil;

public class ContactControllerTest extends BaseTest {
    private static final JsonMapper MAPPER = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Autowired
    private MockMvc mockMvc;
    @Order(1)
    @Test
    @SneakyThrows
    public void getContactWithCorrectId() {
        mockMvc.perform(get(CONTACT_SERVICE+"?id=64f1cf9f8ecd7f0e5b2f3951")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Order(2)
    @Test
    @SneakyThrows
    public void deleteContact() {
        mockMvc.perform(get(CONTACT_SERVICE+"?id=64f1cf9d8ecd7f0e5b2f394b")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Order(3)
    @Test
    @SneakyThrows
    public void createContact() {
        ContactRequest request = FactoryUtil.createContactBody();
        mockMvc.perform(post(CONTACT_SERVICE)
                .contentType(APPLICATION_JSON)
                        .content(MAPPER.writeValueAsString(request))
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Order(4)
    @Test
    @SneakyThrows
    public void updateContact() {
        ContactUpdateRequest request = FactoryUtil.updateContactBody();
        mockMvc.perform(post(CONTACT_SERVICE)
                        .contentType(APPLICATION_JSON)
                        .content(MAPPER.writeValueAsString(request))
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
