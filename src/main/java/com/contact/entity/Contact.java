package com.contact.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Contact {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phoneNumber;
}
