package com.codegym.chuongtrinhluugiucauhinhhomthudientu.controller;

import com.codegym.chuongtrinhluugiucauhinhhomthudientu.model.Setting;
import com.codegym.chuongtrinhluugiucauhinhhomthudientu.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/settings")
public class SettingController {
    @Autowired
    private SettingService settingService;

    @GetMapping("")
    public ModelAndView showSettings() {
        ModelAndView mv = new ModelAndView("setting");
        Setting setting = settingService.show();
        mv.addObject("setting", setting);
        return mv;
    }

    @GetMapping("/save")
    public ModelAndView saveSettings(@ModelAttribute Setting setting) {
        settingService.save(setting);
        ModelAndView mv = showSettings();
        return mv;
    }
}
