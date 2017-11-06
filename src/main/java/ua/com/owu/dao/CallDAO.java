package ua.com.owu.dao;

import ua.com.owu.entity.Call;

import java.util.List;

public interface CallDAO {
    void save(Call call);

    Call find(String id);

    List<Call> findAll();

    void delete(String id);
}
