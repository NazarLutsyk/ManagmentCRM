package ua.com.owu.dao;

import ua.com.owu.entity.Offer;

import java.util.Collection;
import java.util.List;

public interface OfferDAO {
    void save(Offer offer);

    Offer find(String id);

    List<Offer> findAll();

    List<Offer> findByIds(Collection<String> ids);

    void delete(String id);
}
