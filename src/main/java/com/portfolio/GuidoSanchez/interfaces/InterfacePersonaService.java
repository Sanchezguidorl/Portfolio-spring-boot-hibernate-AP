package com.portfolio.GuidoSanchez.interfaces;

import com.portfolio.GuidoSanchez.models.Persona;
import java.util.List;
//Se definen metodos para realizar CRUD de la entidad Persona

public interface InterfacePersonaService {

    public List<Persona> getAll();

    public void save(Persona persona);

    public void delete(Long id);

    public Persona findById(Long id);
}
