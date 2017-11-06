package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.OfferDAO;
import ua.com.owu.entity.Offer;
import ua.com.owu.service.OfferService;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferDAO offerDAO;

    @Override
    public void save(Offer offer) {
        offerDAO.save(offer);
    }

    @Override
    public Offer find(String id) {
        return offerDAO.find(id);
    }

    @Override
    public List<Offer> findAll() {
        return offerDAO.findAll();
    }

    @Override
    public void delete(String id) {
        offerDAO.delete(id);
    }
}
