package ua.com.owu.service;

import ua.com.owu.entity.Status;

import java.util.Collection;
import java.util.List;

public interface StatusService {
    void save(Status status);

    Status find(String id);

    List<Status> findAll();

    List<Status> findByIds(Collection<String> ids);

    void delete(String id);
}
