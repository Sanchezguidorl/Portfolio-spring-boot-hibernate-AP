package com.portfolio.GuidoSanchez.services;

import com.portfolio.GuidoSanchez.interfaces.InterfacePersonaService;
import com.portfolio.GuidoSanchez.models.Persona;
import com.portfolio.GuidoSanchez.repositories.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Contiene las funciones necesarias para un CRUD relacionado a la entidad Persona
 */
@Service
public class PersonaService implements InterfacePersonaService {

    //Se inserta como dependencia la entidad Persona por medio de su interface Repository
    @Autowired
    private PersonaRepository persoRepository;

    //Trae todos los registros
    @Override
    public List<Persona> getAll() {
        List<Persona> personas = persoRepository.findAll();
        return personas;
    }

    //Crea un nuevo registro
    @Override
    public void save(Persona persona) {
        persoRepository.save(persona);
    }

    //Elimina un registro segun Id
    @Override
    public void delete(Long id) {
        persoRepository.deleteById(id);
    }

    //Busca un registro segun Id
    @Override
    public Persona findById(Long id) {
        Persona persona = persoRepository.findById(id).orElse(null);
        return persona;
    }
}
