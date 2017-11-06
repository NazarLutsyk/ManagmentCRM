package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.CompanyDAO;
import ua.com.owu.entity.Company;
import ua.com.owu.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public void save(Company call) {
        companyDAO.save(call);
    }

    @Override
    public Company find(String id) {
        return companyDAO.find(id);
    }

    @Override
    public List<Company> findAll() {
        return companyDAO.findAll();
    }

    @Override
    public void delete(String id) {
        companyDAO.delete(id);
    }
}
