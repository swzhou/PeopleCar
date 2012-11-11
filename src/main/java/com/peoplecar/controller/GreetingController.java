package com.peoplecar.controller;

import com.peoplecar.domain.Greeting;
import com.peoplecar.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="hello")
public class GreetingController {
    private GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping(method= RequestMethod.GET, value = "/{name}")
    public @ResponseBody Greeting greeting(@PathVariable String name, Model model){
        return greetingService.greeting(name, "How are you?");
    }
}
