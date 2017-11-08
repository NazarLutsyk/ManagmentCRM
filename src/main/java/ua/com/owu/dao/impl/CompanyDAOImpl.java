package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.CompanyDAO;
import ua.com.owu.entity.Company;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO{
    @Autowired
    private Datastore datastore;

    @Override
    public void save(Company company) {
        datastore.save(company);
        System.out.println("Company saved:"+ company );
    }

    @Override
    public Company find(String id) {
        Company company = datastore.get(Company.class, new ObjectId(id));
        System.out.println("Found company by id:" + id);
        return company;
    }

    @Override
    public List<Company> findAll() {
        List<Company> company = datastore.find(Company.class).asList();
        System.out.println("Fount all companies:" + company);
        return company;
    }

    @Override
    public void delete(String id) {
        datastore.delete(Company.class,new ObjectId(id));
        System.out.println("Company deleted by id:" + id);
    }
}
