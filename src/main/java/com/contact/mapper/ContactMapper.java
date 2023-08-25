package com.contact.mapper;

import com.contact.entity.Contact;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    public Contact toContact(ContactRequest contactRequest);
    public Contact toContactResponse(Contact contact);
    public Contact updateProduct(ContactUpdateRequest contactUpdateRequest, @MappingTarget Contact contact);
    public List<Contact> toContactsResponse(List<Contact> contacts);
}
