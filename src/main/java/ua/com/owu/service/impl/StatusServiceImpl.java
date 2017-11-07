package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.owu.dao.StatusDAO;
import ua.com.owu.entity.Status;
import ua.com.owu.service.StatusService;

import java.util.Collection;
import java.util.List;

@Repository
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusDAO statusDAO;

    @Override
    public void save(Status status) {
        statusDAO.save(status);
    }

    @Override
    public Status find(String id) {
        return statusDAO.find(id);
    }

    @Override
    public List<Status> findAll() {
        return statusDAO.findAll();
    }

    @Override
    public List<Status> findByIds(Collection<String> ids) {
        return statusDAO.findByIds(ids);
    }

    @Override
    public void delete(String id) {
        statusDAO.delete(id);
    }
}
