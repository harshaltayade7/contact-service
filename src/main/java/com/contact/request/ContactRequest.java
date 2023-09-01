package com.contact.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phoneNumber;
}
