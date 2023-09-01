package com.contact.mapper;

import com.contact.entity.Contact;
import com.contact.request.ContactRequest;
import com.contact.request.ContactUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {
    public Contact toContact(ContactRequest contactRequest);
    public Contact toContactResponse(Contact contact);
    public Contact updateContact(ContactUpdateRequest contactUpdateRequest, @MappingTarget Contact contact);
    public List<Contact> toContactListResponse(List<Contact> contacts);
}
