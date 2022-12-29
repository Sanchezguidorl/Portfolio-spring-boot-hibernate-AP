/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GuidoSanchez.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
/*Controlador que brinda saludo para el método main de inicio de ejecución*/
public class SaludoController {
    @GetMapping("/")
    public String bienvenida(){
        return "Bienvenido, este es el port inicial donde se ejecuta el proyecto";
    }
}
