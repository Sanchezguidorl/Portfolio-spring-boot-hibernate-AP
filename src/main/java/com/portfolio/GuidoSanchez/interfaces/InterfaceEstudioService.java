
package com.portfolio.GuidoSanchez.interfaces;

import com.portfolio.GuidoSanchez.models.Estudio;
import java.util.List;


public interface InterfaceEstudioService {
    public List<Estudio> getAllEstudios();
    public void save(Estudio estudio);
    public void delete(Long id);
    public Estudio findEstudio(Long id);
}
