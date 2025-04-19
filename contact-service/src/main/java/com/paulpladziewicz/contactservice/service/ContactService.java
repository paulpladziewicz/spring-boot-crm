package com.paulpladziewicz.contactservice.service;

import com.paulpladziewicz.contactservice.model.Contact;
import com.paulpladziewicz.contactservice.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return this.contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Integer id) {
        return this.contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return this.contactRepository.save(contact);
    }
}
