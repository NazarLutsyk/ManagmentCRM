package ua.com.owu.service;

import ua.com.owu.entity.ContactPerson;

import java.util.List;

public interface ContactPersonService {
    void save(ContactPerson call);

    ContactPerson find(String id);

    List<ContactPerson> findAll();

    void delete(String id);
}
