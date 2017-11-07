package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.TaskDAO;
import ua.com.owu.entity.Task;
import ua.com.owu.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDAO taskDAO;

    @Override
    public void save(Task task) {
        taskDAO.save(task);
    }

    @Override
    public Task find(String id) {
        return taskDAO.find(id);
    }

    @Override
    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    @Override
    public void delete(String id) {
        taskDAO.delete(id);
    }
}
