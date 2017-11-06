package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.ResultDAO;
import ua.com.owu.entity.Result;
import ua.com.owu.service.ResultService;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultDAO resultDAO;

    @Override
    public void save(Result call) {
        resultDAO.save(call);
    }

    @Override
    public Result find(String id) {
        return resultDAO.find(id);
    }

    @Override
    public List<Result> findAll() {
        return resultDAO.findAll();
    }

    @Override
    public void delete(String id) {
        resultDAO.delete(id);
    }
}
