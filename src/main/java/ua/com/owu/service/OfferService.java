package ua.com.owu.service;

import ua.com.owu.entity.Offer;

import java.util.List;

public interface OfferService {
    void save(Offer offer);

    Offer find(String id);

    List<Offer> findAll();

    void delete(String id);
}
