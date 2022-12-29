package com.portfolio.GuidoSanchez.controllers;

import com.portfolio.GuidoSanchez.interfaces.InterfacePersonaService;
import com.portfolio.GuidoSanchez.models.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mis-datos")
public class PersonaController {

    //Se inserta como dependencia la interface de Persona para obtener los metodos CRUD
    @Autowired
    public InterfacePersonaService persoService;

    //Trae todos los registros
    @GetMapping("/guido-sanchez")
    public List<Persona> traerDatos() {
List<Persona> personas=persoService.getAll();
        return personas;
    }

    //Crea un nuevo registro
    @PostMapping("/crear-dev")
    public void crearPersona(@RequestBody Persona persona) {
        persoService.save(persona);
    }

    //Elimina un registro segun Id
/*    @DeleteMapping("/eliminar-cuenta")
    public String eliminarUsuario(Long id) {
        try {
                    persoService.delete(id);
                    return "El usuario único se ha eliminado correctamente";
        } catch (Exception e) {
            return "El usuario no pudo ser eliminado";
        }
    }
     */
    //Busca un registro segun Id y modifica datos del mismo
    @PutMapping("/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellidos,
            @RequestParam("provincia") String provincia,
            @RequestParam("email") String email,
            @RequestParam("fecha_nacimiento") String nacimiento,
            @RequestParam("sobre_mi") String descripcion,
            @RequestParam("url_foto") String foto) {
        Persona persona = persoService.findById(id);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setEmail(email);
        persona.setProvincia(provincia);
        persona.setFecha_nacimiento(nacimiento);
        persona.setSobre_mi(descripcion);
        persona.setUrl_foto(foto);
        persoService.save(persona);

        return persona;
    }
}
