/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.GuidoSanchez.services;

import com.portfolio.GuidoSanchez.models.Usuario;
import com.portfolio.GuidoSanchez.interfaces.InterfaceUsuarioService;
import com.portfolio.GuidoSanchez.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements InterfaceUsuarioService {
//Se inserta como dependencia la entidad Persona por medio de su interface Repository

    @Autowired
    private UsuarioRepository usuarioRepo;
    //Trae todos los registros

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }
//Crea un nuevo registro

    @Override
    public void save(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    //Elimina un registro segun Id
    @Override
    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    //Busca un registro segun Id
    @Override
    public Usuario edit(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }
}
