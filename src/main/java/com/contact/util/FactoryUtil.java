package com.contact.util;

import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;

public class FactoryUtil {
    public static ContactRequest createContactBody() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setFirstName("Harshal");
        contactRequest.setLastName("Tayade");
        contactRequest.setCompany("T-Systems");
        contactRequest.setEmail("Harshal.Tayade@t-systems.com");
        contactRequest.setPhoneNumber("8975300272");

        return contactRequest;
    }

    public static ContactUpdateRequest updateContactBody() {
        ContactUpdateRequest updateRequest = new ContactUpdateRequest();
        updateRequest.setId("64f1cf8a8ecd7f0e5b2f3948");
        updateRequest.setFirstName("Harshal");
        updateRequest.setLastName("Tayade");
        updateRequest.setCompany("T-Systems");
        updateRequest.setEmail("Harshal.Tayade@t-systems.com");
        updateRequest.setPhoneNumber("8975300272");
        return updateRequest;
    }

}
