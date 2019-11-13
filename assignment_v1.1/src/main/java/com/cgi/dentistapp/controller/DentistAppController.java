package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

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
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("dentists", dentistVisitService.getAllDentists());
            return "form";
        }
        dentistVisitService.addVisit(dentistVisitDTO);
        ra.addFlashAttribute("message", "Success");
        return "redirect:/results";
    }

    @GetMapping("/results")
    public String showList(Model model) {
        model.addAttribute("dentistVisits", dentistVisitService.getAll());
        return "results";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        System.out.println(id);
        System.out.println(dentistVisitService.findById(id));
        model.addAttribute("dentistVisit", dentistVisitService.findById(id));
        return "details";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        System.out.println(id);
        System.out.println("in delete");
        return "In delete!" + id;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id) {
        System.out.println(id);
        System.out.println("in edit");
        return "In delete!" + id;
    }
}
