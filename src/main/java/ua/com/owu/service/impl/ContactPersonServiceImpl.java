package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.ContactPersonDAO;
import ua.com.owu.entity.ContactPerson;
import ua.com.owu.service.ContactPersonService;

import java.util.List;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {
    @Autowired
    private ContactPersonDAO contactPersonDAO;

    @Override
    public void save(ContactPerson call) {
        contactPersonDAO.save(call);
    }

    @Override
    public ContactPerson find(String id) {
        return contactPersonDAO.find(id);
    }

    @Override
    public List<ContactPerson> findAll() {
        return contactPersonDAO.findAll();
    }

    @Override
    public void delete(String id) {
        contactPersonDAO.delete(id);
    }
}
