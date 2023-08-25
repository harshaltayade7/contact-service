package com.contact.service;


import com.contact.entity.Contact;
import com.contact.exceptions.ItemNotFoundException;
import com.contact.mapper.ContactMapper;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ContactService {
    private final MongoTemplate mongoTemplate;
    private final ContactMapper contactMapper;

    public Query contactQuery(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return query;
    }
    public Contact getContact(String id) {
        Contact contact = mongoTemplate.findOne(contactQuery(id), Contact.class);
        return contact;
    }
    public List<Contact> getContacts() {
        return contactMapper.toContactsResponse(mongoTemplate.findAll(Contact.class));
    }
    public Contact createContact(ContactRequest contactRequest) {
        Contact response = mongoTemplate.save(contactMapper.toContact(contactRequest));
        return response;
    }

    public Contact updateContact(ContactUpdateRequest contactUpdateRequest) {
        Contact updatedContact = contactMapper.updateProduct(contactUpdateRequest, getContact(contactUpdateRequest.getId()));
        Contact response = contactMapper.toContactResponse(mongoTemplate.save(updatedContact));
        return response;
    }
    public ResponseEntity<String> removeContact(String id) {
       Contact contact = getContact(id);
       if(ObjectUtils.isEmpty(contact)) {
           throw new ItemNotFoundException("Item not found");
       } else {
           mongoTemplate.remove(contact);
           return new ResponseEntity<>( "Contact with id "+ id+" has been removed successfully", HttpStatus.OK);
       }
    }
}
