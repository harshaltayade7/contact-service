package com.contact.controller;

import com.contact.entity.Contact;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import com.contact.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Optional<Contact> getContact(@RequestParam UUID id) {
        return contactService.getContact(id);
    }
    @GetMapping("/all")
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody @Valid ContactRequest contactRequest) {
        return contactService.createContact(contactRequest);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Contact updateContact(@RequestBody @Valid ContactUpdateRequest contactUpdateRequest) {
        return contactService.updateContact(contactUpdateRequest);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.FOUND)
    public void removeContact(@RequestParam UUID id) {
        contactService.removeContact(id);
    }
}
