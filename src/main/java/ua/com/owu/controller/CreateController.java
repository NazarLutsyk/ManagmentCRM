package ua.com.owu.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.owu.entity.*;
import ua.com.owu.service.*;
import ua.com.owu.service.utils.Helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CallService callService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private ContactPersonService contactPersonService;

    @PostMapping("/createOffer")
    public void createOffer(@RequestParam String name,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Offer offer = Offer.builder()
                .id(new ObjectId())
                .name(name)
                .build();
        offerService.save(offer);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/createCall")
    public void createOffer(@RequestParam String date,
                            @RequestParam String description,
                            @RequestParam String companyId,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException, ParseException {
        Company company = companyService.find(companyId);
        Call call = Call.builder()
                .id(new ObjectId())
                .description(description)
                .date(Helper.dateFormater(date))
                .company(company)
                .build();
        company.getCalls().add(call);

        callService.save(call);
        companyService.save(company);

        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/createTask")
    public void createTask(@RequestParam String description,
                           @RequestParam String dateExec,
                           @RequestParam String companyId,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException, ParseException {
        Company company = companyService.find(companyId);

        Task task = Task.builder()
                .id(new ObjectId())
                .description(description)
                .dateExec(Helper.dateFormater(dateExec))
                .company(company)
                .build();
        company.getTasks().add(task);

        taskService.save(task);
        companyService.save(company);

        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/createStatus")
    public void createStatus(@RequestParam String value,
                             @RequestParam(required = false, defaultValue = "null") List<String> offersIds,
                             @RequestParam String companyId,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        Company company = companyService.find(companyId);

        Status status = Status.builder()
                .id(new ObjectId())
                .value(value)
                .offers(offersIds == null? new ArrayList<>() : offerService.findByIds(offersIds))
                .company(company)
                .build();
        company.getStatuses().add(status);

        statusService.save(status);
        companyService.save(company);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/createContactPerson")
    public void createOffer(@RequestParam String name,
                            @RequestParam String lastname,
                            @RequestParam String position,
                            @RequestParam String phone,
                            @RequestParam String email,
                            @RequestParam String companyId,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Company company = companyService.find(companyId);
        ContactPerson contactPerson = ContactPerson.builder()
                .id(new ObjectId())
                .name(name)
                .lastname(lastname)
                .position(position)
                .phone(phone)
                .email(email)
                .company(company)
                .build();
        company.getContactPeople().add(contactPerson);

        contactPersonService.save(contactPerson);
        companyService.save(company);

        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    @PostMapping("/createCompany")
    public void createOffer(@RequestParam String name,
                            @RequestParam String phone,
                            @RequestParam String email,
                            @RequestParam String adress,
                            @RequestParam String url,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Company company = Company.builder()
                .id(new ObjectId())
                .name(name)
                .phone(phone)
                .email(email)
                .adress(adress)
                .url(url)
                .calls(new ArrayList<>())
                .contactPeople(new ArrayList<>())
                .statuses(new ArrayList<>())
                .build();
        companyService.save(company);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }
}
