package com.contact.controller;

import com.contact.entity.Contact;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import com.contact.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("contact")
public class ContactController {
    private final ContactService contactService;
    @GetMapping()
    public Optional<Contact> getContact(@RequestParam String id) {
        return contactService.getContact(id);
    }
    @GetMapping("/all")
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }
    @PostMapping
    public Contact createContact(@RequestBody @Valid ContactRequest contactRequest) {
        return contactService.createContact(contactRequest);
    }
    @PutMapping()
    public Contact updateContact(@RequestBody @Valid ContactUpdateRequest contactUpdateRequest) {
        return contactService.updateContact(contactUpdateRequest);
    }
    @DeleteMapping
    public String removeContact(@RequestParam String id) {
        return contactService.removeContact(id);
    }
}
