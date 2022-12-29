/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GuidoSanchez.controllers;

import com.portfolio.GuidoSanchez.interfaces.InterfaceProyectoService;
import com.portfolio.GuidoSanchez.models.Proyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    public InterfaceProyectoService proyectoService;
    //Trae todos los registros

    @GetMapping("/lista")
    public List<Proyecto> traerProyectos() {
        List<Proyecto> proyectos = proyectoService.getAll();
        return proyectos;
    }

    //Crea un nuevo registro
    @PostMapping("/agregar")
    public void crearPersona(@RequestBody Proyecto proyecto) {
        proyectoService.save(proyecto);
    }

    //Elimina un registro segun Id
    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        try {
            proyectoService.delete(id);
            return "El proyecto se ha eliminado correctamente";
        } catch (Exception e) {
            return "El proyecto no pudo ser eliminado";
        }
    }

    //Busca un registro segun Id y modifica datos del mismo
    @PutMapping("/editar/{id}")
    public Proyecto editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("url_proyecto") String urlpj,
            @RequestParam("url_miniatura") String miniatura,
            @RequestParam("fecha_creacion") String fecha_creacion,
            @RequestParam("descripcion") String descripcion) {
        Proyecto proyecto = proyectoService.findById(id);
        proyecto.setNombre(nombre);
        proyecto.setUrl_proyecto(urlpj);
        proyecto.setDescripcion(descripcion);
        proyecto.setUrl_miniatura(miniatura);
        proyecto.setFecha_creacion(fecha_creacion);
        proyectoService.save(proyecto);

        return proyecto;
    }
}
