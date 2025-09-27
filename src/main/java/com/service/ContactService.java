package com.service;
import com.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Integer id);
    void saveContact(Contact contact);
    void deleteContactById(Integer id);
}