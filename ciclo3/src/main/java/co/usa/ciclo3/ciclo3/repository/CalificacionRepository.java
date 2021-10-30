package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Calificacion;
import co.usa.ciclo3.ciclo3.repository.crud.CalificacionCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CalificacionRepository {

    @Autowired
    private CalificacionCrudRepository calificacionCrudRepository;

    public List<Calificacion> getAll() {
        return (List<Calificacion>) calificacionCrudRepository.findAll();
    }

    public Optional<Calificacion> getCalificacion(int id) {
        return calificacionCrudRepository.findById(id);
    }

    public Calificacion save(Calificacion calificacion) {
        return calificacionCrudRepository.save(calificacion);
    }

    public void delete(Calificacion calificacion) {
        calificacionCrudRepository.delete(calificacion);
    }

}
