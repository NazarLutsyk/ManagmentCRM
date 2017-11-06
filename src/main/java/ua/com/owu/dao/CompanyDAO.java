package ua.com.owu.dao;

import ua.com.owu.entity.Company;

import java.util.List;

public interface CompanyDAO {
    void save(Company call);

    Company find(String id);

    List<Company> findAll();

    void delete(String id);
}
