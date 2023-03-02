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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proyectos")
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
    public Boolean eliminarUsuario(@PathVariable Long id) {
        try {
            proyectoService.delete(id);
            return true;
        } catch (Exception e) {
 return false;
        }
    }

    //Busca un registro segun Id y modifica datos del mismo
    @PutMapping("/editar/{id}")
    public Proyecto editarPersona(@PathVariable Long id,
@RequestBody Proyecto proyectoEdit) {
        Proyecto proyecto = proyectoService.findById(id);
        proyecto.setNombre(proyectoEdit.getNombre());
        proyecto.setUrl_proyecto(proyectoEdit.getUrl_proyecto());
        proyecto.setDescripcion(proyectoEdit.getDescripcion());
        proyecto.setUrl_miniatura(proyectoEdit.getUrl_miniatura());
        proyecto.setFecha_creacion(proyectoEdit.getFecha_creacion());
        proyectoService.save(proyecto);

        return proyecto;
    }
        //Busca un registro segun Id 
    @GetMapping("/{id}")
    public Proyecto traerPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.findById(id);
        return proyecto;
    }
}
