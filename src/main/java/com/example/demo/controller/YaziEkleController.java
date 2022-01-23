package com.example.demo.controller;

import com.example.demo.Repositories.YaziRepository;
import com.example.demo.entity.Yazi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class YaziEkleController {
    final YaziRepository yaziRepository;

    public YaziEkleController(YaziRepository yaziRepository) {
        this.yaziRepository = yaziRepository;
    }

    @GetMapping("/blogform.html")
    public String blogform()
    {
        return "blogform";
    }
    @PostMapping("/save")
    public String save(Yazi yazi) {
        yaziRepository.save(yazi);
        return "redirect:/yazilar.html";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            yaziRepository.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/yazilar.html";
    }


}
