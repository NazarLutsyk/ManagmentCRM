package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.dao.CallDAO;
import ua.com.owu.entity.Call;
import ua.com.owu.service.CallService;

import java.util.List;

@Service
public class CallServiceImpl implements CallService {
    @Autowired
    private CallDAO callDAO;

    @Override
    public void save(Call call) {
        callDAO.save(call);
    }

    @Override
    public Call find(String id) {
        return callDAO.find(id);
    }

    @Override
    public List<Call> findAll() {
        return callDAO.findAll();
    }

    @Override
    public void delete(String id) {
        callDAO.delete(id);
    }
}
