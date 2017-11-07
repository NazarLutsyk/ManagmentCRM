package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.TaskDAO;
import ua.com.owu.entity.Status;
import ua.com.owu.entity.Task;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO{
    @Autowired
    private Datastore datastore;

    @Override
    public void save(Task task) {
        datastore.save(task);
        System.out.println("Task saved:" + task);
    }

    @Override
    public Task find(String id) {
        Task task = datastore.get(Task.class, new ObjectId(id));
        System.out.println("Found task by id:" + task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = datastore.find(Task.class).asList();
        System.out.println("Fount all tasks:" + tasks);
        return tasks;
    }

    @Override
    public void delete(String id) {
        datastore.delete(Task.class,new ObjectId(id));
        System.out.println("Deleted task by id:" + id);
    }
}
