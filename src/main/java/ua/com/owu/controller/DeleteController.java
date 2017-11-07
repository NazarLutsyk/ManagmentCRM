package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.owu.entity.*;
import ua.com.owu.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DeleteController {
    @Autowired
    private ContactPersonService contactPersonService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CallService callService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StatusService statusService;

    @PostMapping("/deleteContactPerson/{contactPersonId}")
    public void deleteContactPerson(@PathVariable String contactPersonId,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        ContactPerson contactPerson = contactPersonService.find(contactPersonId);
        contactPersonService.delete(contactPerson.getId().toString());

        Company company = contactPerson.getCompany();
        company.getContactPeople().remove(contactPerson);

        companyService.save(company);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/deleteCall/{callId}")
    public void deleteCall(@PathVariable String callId,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        Call call = callService.find(callId);
        callService.delete(call.getId().toString());

        Company company = call.getCompany();
        company.getCalls().remove(call);

        companyService.save(company);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/deleteTask/{taskId}")
    public void deleteTask(@PathVariable String taskId,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        Task task = taskService.find(taskId);
        taskService.delete(task.getId().toString());

        Company company = task.getCompany();
        company.getTasks().remove(task);

        companyService.save(company);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/deleteStatus/{statusId}")
    public void deleteStatus(@PathVariable String statusId,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        Status status = statusService.find(statusId);
        Company company = status.getCompany();

        company.getStatuses().remove(status);

        statusService.delete(statusId);
        companyService.save(company);

        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }
}
