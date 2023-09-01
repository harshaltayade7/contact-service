package com.contact.service;
import com.contact.entity.Contact;
import com.contact.exceptions.ItemNotFoundException;
import com.contact.mapper.ContactMapper;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contact.repositories.ContactRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ContactService {
    @Autowired
    private final ContactRepository repository;
    private final ContactMapper contactMapper;

    public Optional<Contact> getContact(String id) {
        return Optional.ofNullable(repository.findById(UUID.fromString(id)).orElseThrow(() -> new ItemNotFoundException("")));
    }
    public List<Contact> getContacts() {
        return contactMapper.toContactListResponse(repository.findAll());
    }
    public Contact createContact(ContactRequest contactRequest) {
        Contact response = repository.save(contactMapper.toContact(contactRequest));
        return response;
    }
    public Contact updateContact(ContactUpdateRequest contactUpdateRequest) {
            Contact contact = repository.findById(UUID.fromString(new String(contactUpdateRequest.getId()))).orElseThrow(()-> new ItemNotFoundException("Contact not found"));
            var mapping = contactMapper
               .updateContact(contactUpdateRequest, contact);
        return mapping;
    }
    public void removeContact(String id) {
        if (!repository.existsById(UUID.fromString(id)))
            throw new ItemNotFoundException("Contact not found");
        repository.deleteById(UUID.fromString(id));
    }
}
