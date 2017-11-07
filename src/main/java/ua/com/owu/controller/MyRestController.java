package ua.com.owu.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.entity.*;
import ua.com.owu.service.*;

@RestController
public class MyRestController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private CallService callService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StatusService statusService;

    @PostMapping("/liveEditOffer")
    public void liveEditOffer(@RequestBody Offer offer) {
        offerService.save(offer);
    }

    @PostMapping("/liveEditCompany")
    public void liveEditCompany(@RequestBody Company company) {
        Company oldCompany = companyService.find(company.getId().toString());
        BeanUtils.copyProperties(company,oldCompany,"status","tasks","calls","contactPeople");
        companyService.save(oldCompany);
    }

    @PostMapping("/liveEditContactPerson")
    public void liveEditContactPerson(@RequestBody ContactPerson contactPerson) {
        ContactPerson oldContactPerson = contactPersonService.find(contactPerson.getId().toString());
        BeanUtils.copyProperties(contactPerson,oldContactPerson,"company");
        contactPersonService.save(contactPerson);
    }

    @PostMapping("/liveEditCall")
    public void liveEditCall(@RequestBody Call call) {
        Call oldCall = callService.find(call.getId().toString());
        BeanUtils.copyProperties(call,oldCall,"company");
        callService.save(oldCall);
    }

    @PostMapping("/liveEditTask")
    public void liveEditTask(@RequestBody Task task) {
        Task oldTask = taskService.find(task.getId().toString());
        BeanUtils.copyProperties(task,oldTask,"company","checker");
        taskService.save(oldTask);
    }

    @PostMapping("/liveEditStatus")
    public void liveEditStatus(@RequestBody Status status) {
        Status oldStatus = statusService.find(status.getId().toString());
        BeanUtils.copyProperties(status,oldStatus,"offers", "company");
        statusService.save(oldStatus);
    }

    @PostMapping("/reverseTaskChecker")
    public void reverseTaskChecker(@RequestBody String taskId) {
        Task task = taskService.find(taskId);
        task.setChecker(!task.isChecker());
        taskService.save(task);
    }
}
