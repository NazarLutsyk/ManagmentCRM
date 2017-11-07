package ua.com.owu.dao;

import ua.com.owu.entity.Task;

import java.util.List;

public interface TaskDAO {
    void save(Task task);

    Task find(String id);

    List<Task> findAll();

    void delete(String id);
}
