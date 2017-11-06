package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.CallDAO;
import ua.com.owu.entity.Call;

import java.util.List;

@Repository
public class CallDAOImpl implements CallDAO{
    @Autowired
    private Datastore datastore;

    @Override
    public void save(Call call) {
        datastore.save(call);
        System.out.println("Call" + call + "saved");
    }

    @Override
    public Call find(String id) {
        Call call = datastore.get(Call.class, new ObjectId(id));
        System.out.println("Found call by id:" + id);
        return call;
    }

    @Override
    public List<Call> findAll() {
        List<Call> calls = datastore.find(Call.class).asList();
        System.out.println("Fount all calls:" + calls);
        return calls;
    }

    @Override
    public void delete(String id) {
        datastore.delete(Call.class,new ObjectId(id));
        System.out.println("Call deleted by id:" + id);
    }
}
