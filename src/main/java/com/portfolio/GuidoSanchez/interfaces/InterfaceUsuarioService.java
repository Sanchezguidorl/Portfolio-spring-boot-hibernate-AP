/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.GuidoSanchez.interfaces;

import com.portfolio.GuidoSanchez.models.Usuario;
import java.util.List;

public interface InterfaceUsuarioService {

    public List<Usuario> getUsuarios();

    public void save(Usuario usuario);

    public void deleteUsuario(Long id);
    
    public Usuario edit(Long id);

}
