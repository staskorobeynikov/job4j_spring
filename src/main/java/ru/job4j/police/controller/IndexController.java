package ru.job4j.police.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.police.model.Accident;
import ru.job4j.police.service.Service;

@Controller
public class IndexController {

    private final Service<Accident> service;

    @Autowired
    public IndexController(Service<Accident> service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAccidents(ModelMap modelMap) {
        modelMap.addAttribute("accidents", service.findAll());
        return "index";
    }
}
