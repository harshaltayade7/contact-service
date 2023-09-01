package com.contact.service;
import com.contact.entity.Contact;
import com.contact.exceptions.ItemNotFoundException;
import com.contact.mapper.ContactMapper;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.contact.repositories.ContactRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public Optional<Contact> getContact(UUID id) {
        return Optional.ofNullable(contactRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("")));
    }
    public List<Contact> getContacts() {
        return contactMapper.toContactListResponse(contactRepository.findAll());
    }
    public Contact createContact(ContactRequest contactRequest) {
        Contact response = contactRepository.save(contactMapper.toContact(contactRequest));
        return response;
    }
    public Contact updateContact(ContactUpdateRequest contactUpdateRequest) {
        Contact contact = contactRepository.findById(contactUpdateRequest.getId()).orElseThrow(()-> new ItemNotFoundException("Contact not found"));
        var mapping = contactMapper
               .updateContact(contactUpdateRequest, contact);
        return mapping;
    }
    public void removeContact(UUID id) {
        if (!contactRepository.existsById(id))
            throw new ItemNotFoundException("Contact not found");
        contactRepository.deleteById(id);
    }
}
