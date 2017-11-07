package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.StatusDAO;
import ua.com.owu.entity.Status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class StatusDAOImpl implements StatusDAO {
    @Autowired
    private Datastore datastore;

    @Override
    public void save(Status status) {
        datastore.save(status);
        System.out.println("Status saved:" + status);
    }

    @Override
    public Status find(String id) {
        Status status = datastore.get(Status.class, new ObjectId(id));
        System.out.println("Found status by id:" + status);
        return status;
    }

    @Override
    public List<Status> findAll() {
        List<Status> statuses = datastore.find(Status.class).asList();
        System.out.println("Fount all statuses:" + statuses);
        return statuses;
    }

    @Override
    public List<Status> findByIds(Collection<String> ids) {
        List statuses = new ArrayList();
        ids.forEach(id -> {
            statuses.add(find(id));
        });
        System.out.println("Found status list by ids:" + statuses);
        return statuses;
    }

    @Override
    public void delete(String id) {
        datastore.delete(Status.class,new ObjectId(id));
        System.out.println("Deleted status by id:" + id);
    }
}
