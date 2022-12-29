
package com.portfolio.GuidoSanchez.interfaces;

import com.portfolio.GuidoSanchez.models.Proyecto;
import java.util.List;


public interface InterfaceProyectoService {
    
     public List<Proyecto> getAll();

    public void save(Proyecto proyecto);

    public void delete(Long id);

    public Proyecto findById(Long id);
}
