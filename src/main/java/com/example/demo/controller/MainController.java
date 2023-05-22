package com.example.demo.controller;


import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    @Value("${CLIENT.ID}")
    private String clientId;
    @Value("${REDIRECT.URI}")
    private String redirectURI;

    @GetMapping(value = {"/login","/"})
    public String login(Model model){
        model.addAttribute("clientId",clientId);
        model.addAttribute("redirectURI",redirectURI);
        return "index";
    }


}
