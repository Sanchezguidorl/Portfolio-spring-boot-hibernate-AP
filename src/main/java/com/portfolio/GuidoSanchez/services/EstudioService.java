package com.portfolio.GuidoSanchez.services;

import com.portfolio.GuidoSanchez.interfaces.InterfaceEstudioService;
import com.portfolio.GuidoSanchez.models.Estudio;
import com.portfolio.GuidoSanchez.repositories.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements InterfaceEstudioService {
    //Se inserta como dependencia la entidad Estudio por medio de su interface Repository

    @Autowired
    private EstudioRepository estudiosRepo;
//Trae todos los registros

    @Override
    public List<Estudio> getAllEstudios() {

        return estudiosRepo.findAll();
    }
//Crea un nuevo registro

    @Override
    public void save(Estudio estudio) {
        estudiosRepo.save(estudio);
    }
//Elimina un registro segun Id

    @Override
    public void delete(Long id) {
        estudiosRepo.deleteById(id);
    }
//Busca un registro segun Id

    @Override
    public Estudio findEstudio(Long id) {
        return estudiosRepo.findById(id).orElse(null);
    }

}
