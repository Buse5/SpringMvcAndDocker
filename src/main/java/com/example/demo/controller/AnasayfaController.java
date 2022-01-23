package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnasayfaController {
    @RequestMapping("/index.html")
    public String index()
    {
        return"index";
    }

}
