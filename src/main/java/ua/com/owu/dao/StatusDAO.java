package ua.com.owu.dao;

import ua.com.owu.entity.Status;

import java.util.Collection;
import java.util.List;

public interface StatusDAO {
    void save(Status status);

    Status find(String id);

    List<Status> findAll();

    List<Status> findByIds(Collection<String> ids);

    void delete(String id);
}
