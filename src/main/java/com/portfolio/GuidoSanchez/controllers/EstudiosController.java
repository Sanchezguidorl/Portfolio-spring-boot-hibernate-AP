
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudios")
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
    public Boolean eliminarEstudio(@PathVariable Long id) {
        try {
            estudioService.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Busca un registro segun Id y modifica datos del mismo
    @PutMapping("/editar/{id}")
    public Estudio editarPersona(@PathVariable Long id,@RequestBody Estudio estudioUpdate) {
        Estudio estudio = estudioService.findEstudio(id);
        estudio.setNombre_institucion(estudioUpdate.getNombre_institucion());
        estudio.setNombre_curso(estudioUpdate.getNombre_curso());
        estudio.setUrl_logo(estudioUpdate.getUrl_logo());
        estudio.setFecha_inicio(estudioUpdate.getFecha_inicio());
        estudio.setEstado_cursado(estudioUpdate.getEstado_cursado());
        estudioService.save(estudio);
        return estudio;
    }
    //Busca un registro segun Id 
    @GetMapping("/{id}")
    public Estudio traerPorId(@PathVariable Long id) {
        Estudio estudio = estudioService.findEstudio(id);
        return estudio;
    }
}
