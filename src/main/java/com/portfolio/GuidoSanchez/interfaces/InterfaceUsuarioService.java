
 
package com.portfolio.GuidoSanchez.interfaces;

import com.portfolio.GuidoSanchez.models.Usuario;
import java.util.List;

public interface InterfaceUsuarioService {

    public List<Usuario> getUsuarios();

    public void save(Usuario usuario);

    public void deleteUsuario(Integer id);
    
    public Usuario edit(Integer id);

}
