package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.ContactPersonDAO;
import ua.com.owu.entity.ContactPerson;

import java.util.List;

@Repository
public class ContactPersonDAOImpl implements ContactPersonDAO {
    @Autowired
    private Datastore datastore;

    @Override
    public void save(ContactPerson call) {
        datastore.save(call);
        System.out.println("ContactPerson saved:" + call);
    }

    @Override
    public ContactPerson find(String id) {
        ContactPerson contactPerson = datastore.get(ContactPerson.class, new ObjectId(id));
        System.out.println("Found contactPerson by id:" + id);
        return contactPerson;
    }

    @Override
    public List<ContactPerson> findAll() {
        List<ContactPerson> contactPeople = datastore.find(ContactPerson.class).asList();
        System.out.println("Fount all contactPersons:" + contactPeople);
        return contactPeople;
    }

    @Override
    public void delete(String id) {
        datastore.delete(ContactPerson.class, new ObjectId(id));
        System.out.println("ContactPerson deleted by id:" + id);
    }
}
