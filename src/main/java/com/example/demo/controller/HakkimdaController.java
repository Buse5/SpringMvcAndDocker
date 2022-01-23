package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HakkimdaController {
    @RequestMapping("/hakkimda.html")
    public String survey()
    {
        return "hakkimda";
    }
}
