
package com.portfolio.GuidoSanchez.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Raiz {
    @GetMapping
    public String bienvenido(){
        return "Bienvenido";
    }
}
