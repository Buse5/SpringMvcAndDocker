package com.example.demo.controller;

import com.example.demo.Repositories.YaziRepository;
import com.example.demo.entity.Yazi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;

@Controller
public class YazilarController {
    final YaziRepository yaziRepository;
    public YazilarController(YaziRepository yaziRepository) {
        this.yaziRepository = yaziRepository;
    }

    @GetMapping("/yazilar.html")
    public String survey(Model model)
    {
        model.addAttribute("list", yaziRepository.findAll());
        return"yazilar";
    }
    @GetMapping("/edit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("yazim", yaziRepository.findById(cid));
            page="/yaziGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page="redirect:/yazilar.html";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateInvoice(@ModelAttribute(name = "yazim") Yazi yazim) {
        yaziRepository.save(yazim);
        return "redirect:/yazilar.html";
    }
}
