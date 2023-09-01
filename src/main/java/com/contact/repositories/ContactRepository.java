package com.contact.repositories;

import com.contact.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ContactRepository extends MongoRepository<Contact, UUID> {
}
