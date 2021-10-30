package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Usuario;
import co.usa.ciclo3.ciclo3.repository.crud.UsuarioCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    public Optional<Usuario> getUsuario(int id) {
        return usuarioCrudRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioCrudRepository.save(usuario);
    }

    public void delete(Usuario usuario) {
        usuarioCrudRepository.delete(usuario);
    }

}