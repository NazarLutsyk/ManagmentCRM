package ua.com.owu.dao;

import ua.com.owu.entity.Result;

import java.util.List;

public interface ResultDAO {
    void save(Result call);

    Result find(String id);

    List<Result> findAll();

    void delete(String id);
}
