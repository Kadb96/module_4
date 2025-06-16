package com.codegym.tokhaiyte.controller;

import com.codegym.tokhaiyte.model.MedicalForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/medical-forms")
public class MedicalFormController {

    @GetMapping("")
    public ModelAndView medicalForms() {
        ModelAndView mv = new ModelAndView("add-form");
        mv.addObject("medicalForm", new MedicalForm());
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView saveMedicalForm(@ModelAttribute MedicalForm medicalForm) {
        ModelAndView mv = new ModelAndView("view-result");
        mv.addObject("medicalForm", medicalForm);
        return mv;
    }
}
