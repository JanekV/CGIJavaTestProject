package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    private final DentistVisitService dentistVisitService;

    public DentistAppController(DentistVisitService dentistVisitService) {
        this.dentistVisitService = dentistVisitService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/details").setViewName("detalis");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO, Model model) {
        model.addAttribute("dentists", dentistVisitService.getAllDentists());
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO,
                                   BindingResult bindingResult, Model model, RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dentists", dentistVisitService.getAllDentists()); // Need to fetch all dentists for the dropdown again.
            return "form";
        }
        dentistVisitService.addVisit(dentistVisitDTO);
        ra.addFlashAttribute("message", "Success");
        return "redirect:/results";
    }

    @GetMapping("/results")
    public String showList(Model model) {
        model.addAttribute("Results", "True");
        model.addAttribute("dentistVisits", dentistVisitService.getAll());
        return "results";
    }

    @GetMapping("/results/search")
    public String search(@RequestParam(defaultValue = "") String key, Model model) {
        model.addAttribute("Results", "True");
        model.addAttribute("dentistVisits", dentistVisitService.search(key));
        return "results";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        model.addAttribute("dentistVisit", dentistVisitService.findById(id));
        return "details";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        dentistVisitService.delete(id);
        return showList(model);
    }

    /*
    * Find entity to edit -> give entity to form view.
    * */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("dentists", dentistVisitService.getAllDentists());
        if (id != null) {
            model.addAttribute("dentistVisitDTO", dentistVisitService.findById(id));
            model.addAttribute("Edit", "True");
        }
        return "form";
    }
}
