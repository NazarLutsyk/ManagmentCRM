package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.owu.service.CompanyService;
import ua.com.owu.service.OfferService;
import ua.com.owu.service.TaskService;

@Controller
public class RouteController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private OfferService offerService;


    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/companies")
    public String companies(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "showAllCompanies";
    }

    @GetMapping("/tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("companies", companyService.findAll());
        return "showAllTasks";
    }

    @GetMapping("/offers")
    public String offers(Model model) {
        model.addAttribute("offers", offerService.findAll());
        return "showAllOffers";
    }

    @GetMapping("/companies/{companyId}")
    public String showCompany(@PathVariable String companyId,
                            Model model) {
        model.addAttribute("company",companyService.find(companyId));
        return "showCompany";
    }

    @GetMapping("/companies/{companyId}/addinfo")
    public String showAddInfoPage(@PathVariable String companyId,
                                  Model model) {
        model.addAttribute("company",companyService.find(companyId));
        model.addAttribute("offers",offerService.findAll());
        return "showAddCompanyInfoPage";
    }
}
