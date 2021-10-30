package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Mensaje;
import co.usa.ciclo3.ciclo3.repository.crud.MensajeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MensajeRepository {

    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> getAll() {
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }

    public Optional<Mensaje> getMensaje(int id) {
        return mensajeCrudRepository.findById(id);
    }

    public Mensaje save(Mensaje mensaje) {
        return mensajeCrudRepository.save(mensaje);
    }

    public void delete(Mensaje mensaje) {
        mensajeCrudRepository.delete(mensaje);
    }

}
