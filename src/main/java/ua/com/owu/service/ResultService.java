package ua.com.owu.service;

import ua.com.owu.entity.Result;

import java.util.List;

public interface ResultService {
    void save(Result call);

    Result find(String id);

    List<Result> findAll();

    void delete(String id);
}
