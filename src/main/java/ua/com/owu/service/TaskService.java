package ua.com.owu.service;

import ua.com.owu.entity.Task;

import java.util.List;

public interface TaskService {
    void save(Task task);

    Task find(String id);

    List<Task> findAll();

    void delete(String id);
}
