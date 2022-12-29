/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GuidoSanchez.services;

import com.portfolio.GuidoSanchez.interfaces.InterfaceProyectoService;
import com.portfolio.GuidoSanchez.models.Proyecto;
import com.portfolio.GuidoSanchez.repositories.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class ProyectoService implements InterfaceProyectoService{
        //Se inserta como dependencia la entidad Proyecto por medio de su interface Repository
    @Autowired
    private ProyectoRepository proyectoRepo;

    //Trae todos los registros
    @Override
    public List<Proyecto> getAll() {
        List<Proyecto> proyectos = proyectoRepo.findAll();
        return proyectos;
    }

    //Crea un nuevo registro
    @Override
    public void save(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
    }

    //Elimina un registro segun Id
    @Override
    public void delete(Long id) {
        proyectoRepo.deleteById(id);
    }

    //Busca un registro segun Id
    @Override
    public Proyecto findById(Long id) {
        Proyecto proyecto = proyectoRepo.findById(id).orElse(null);
        return proyecto;
    }
}
