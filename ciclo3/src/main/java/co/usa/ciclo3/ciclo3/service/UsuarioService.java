package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Usuario;
import co.usa.ciclo3.ciclo3.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository metodosCrud;

    public List<Usuario> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Usuario> getUsuario(int idUsuario) {
        return metodosCrud.getUsuario(idUsuario);
    }

    public Usuario save(Usuario Usuario) {
        if (Usuario.getId()== null) {
            return metodosCrud.save(Usuario);
        } else {
            Optional<Usuario> e = metodosCrud.getUsuario(Usuario.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(Usuario);
            } else {
                return Usuario;
            }
        }
    }

    public Usuario update(Usuario Usuario) {
        if (Usuario.getId() != null) {
            Optional<Usuario> e = metodosCrud.getUsuario(Usuario.getId());
            if (!e.isEmpty()) {
                if (Usuario.getName()!= null) {
                    e.get().setName(Usuario.getName());
                }
                if (Usuario.getEmail()!= null) {
                    e.get().setEmail(Usuario.getEmail());
                }
                if (Usuario.getPassword()!= null) {
                    e.get().setPassword(Usuario.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Usuario;
            }
        } else {
            return Usuario;
        }
    }

    public boolean deleteUsuario(int UsuarioId) {
        Boolean aBoolean = getUsuario(UsuarioId).map(Usuario -> {
            metodosCrud.delete(Usuario);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
