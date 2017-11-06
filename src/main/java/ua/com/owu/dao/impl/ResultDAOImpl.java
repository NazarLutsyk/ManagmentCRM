package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.ResultDAO;
import ua.com.owu.entity.Result;

import java.util.List;

@Repository
public class ResultDAOImpl implements ResultDAO{
    @Autowired
    private Datastore datastore;

    @Override
    public void save(Result call) {
        datastore.save(call);
        System.out.println("Call saved:" + call);
    }

    @Override
    public Result find(String id) {
        Result result = datastore.get(Result.class, new ObjectId(id));
        System.out.println("Found result by id:" + id);
        return result;
    }

    @Override
    public List<Result> findAll() {
        List<Result> results = datastore.find(Result.class).asList();
        System.out.println("Fount all results:" + results);
        return results;
    }

    @Override
    public void delete(String id) {
        datastore.delete(Result.class, new ObjectId(id));
        System.out.println("Result deleted by id:" + id);
    }
}
