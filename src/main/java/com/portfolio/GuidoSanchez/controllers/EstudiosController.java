/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GuidoSanchez.controllers;

import com.portfolio.GuidoSanchez.interfaces.InterfaceEstudioService;
import com.portfolio.GuidoSanchez.models.Estudio;
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
@RequestMapping("/estudios")
public class EstudiosController {

    @Autowired
    public InterfaceEstudioService estudioService;
    //Trae todos los registros

    @GetMapping("/lista")
    public List<Estudio> traerEstudios() {
List<Estudio>estudios=estudioService.getAllEstudios();
        return estudios;
    }

    //Crea un nuevo registro
    @PostMapping("/agregar")
    public void agregarEstudio(@RequestBody Estudio estudio) {
        estudioService.save(estudio);
    }

    //Elimina un registro segun Id
    @DeleteMapping("/eliminar/{id}")
    public String eliminarEstudio(@PathVariable Long id) {
        try {
            estudioService.delete(id);
            return "El estudio se ha eliminado correctamente";
        } catch (Exception e) {
            return "El estudio no pudo ser eliminado";
        }
    }

    //Busca un registro segun Id y modifica datos del mismo
    @PutMapping("/editar/{id}")
    public Estudio editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("fecha") String fechaini,
            @RequestParam("estado") String estado) {
        Estudio estudio = estudioService.findEstudio(id);
        estudio.setNombre_institucion(nombre);
        estudio.setFecha_inicio(fechaini);
        estudio.setEstado_cursado(estado);
        estudioService.save(estudio);
        return estudio;
    }
}
