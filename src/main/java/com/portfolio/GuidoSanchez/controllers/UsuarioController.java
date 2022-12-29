
package com.portfolio.GuidoSanchez.controllers;

import com.portfolio.GuidoSanchez.interfaces.InterfaceUsuarioService;
import com.portfolio.GuidoSanchez.models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private InterfaceUsuarioService usuarioService;
        //Trae todos los registros

    @GetMapping("/lista")
    public List<Usuario> getUsuarios() {
List<Usuario>usuarios=usuarioService.getUsuarios();
        return usuarios;
    }

    //Crea un nuevo registro
    @PostMapping("/crear")
    public void agregarEstudio(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    //Elimina un registro segun Id
    @DeleteMapping("/eliminar/{id}")
    public String eliminarEstudio(@PathVariable Long id) {
        try {
            usuarioService.deleteUsuario(id);
            return "El estudio se ha eliminado correctamente";
        } catch (Exception e) {
            return "El estudio no pudo ser eliminado";
        }
    }

    //Busca un registro segun Id y modifica datos del mismo
    /*@PutMapping("/editar/{id}")
    A futuro se agregaran funciones más seguras para editar los datos de acceso del usuario
    
    */
    
}
