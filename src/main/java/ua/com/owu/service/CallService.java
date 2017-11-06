package ua.com.owu.service;

import ua.com.owu.entity.Call;

import java.util.List;

public interface CallService {
    void save(Call call);

    Call find(String id);

    List<Call> findAll();

    void delete(String id);
}
