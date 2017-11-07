package ua.com.owu.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.OfferDAO;
import ua.com.owu.entity.Offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class OfferDAOImpl implements OfferDAO{
    @Autowired
    private Datastore datastore;

    @Override
    public void save(Offer offer) {
        datastore.save(offer);
        System.out.println("Offer saved:" + offer);
    }

    @Override
    public Offer find(String id) {
        Offer offer = datastore.get(Offer.class, new ObjectId(id));
        System.out.println("Found offer by id:" + id);
        return offer;
    }

    @Override
    public List<Offer> findAll() {
        List<Offer> offers = datastore.find(Offer.class).asList();
        System.out.println("Fount all offers:" + offers);
        return offers;
    }

    @Override
    public List<Offer> findByIds(Collection<String> ids) {
        List<Offer> offers = new ArrayList<>();
        ids.forEach(id -> offers.add(find(id)));
        System.out.println("Found list offers by ids:" + ids);
        return offers;
    }

    @Override
    public void delete(String id) {
        datastore.delete(Offer.class, new ObjectId(id));
        System.out.println("Offer deleted by id:" + id);
    }
}
