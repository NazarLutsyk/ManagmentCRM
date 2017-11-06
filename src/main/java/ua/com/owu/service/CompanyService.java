package ua.com.owu.service;

import ua.com.owu.entity.Company;

import java.util.List;

public interface CompanyService {
    void save(Company call);

    Company find(String id);

    List<Company> findAll();

    void delete(String id);
}
