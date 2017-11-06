package ua.com.owu.dao;

import ua.com.owu.entity.ContactPerson;

import java.util.List;

public interface ContactPersonDAO {
    void save(ContactPerson call);

    ContactPerson find(String id);

    List<ContactPerson> findAll();

    void delete(String id);
}
