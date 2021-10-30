package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Calificacion;
import co.usa.ciclo3.ciclo3.repository.CalificacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository metodosCrud;

    public List<Calificacion> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Calificacion> getCalificacion(int idCalificacion) {
        return metodosCrud.getCalificacion(idCalificacion);
    }

    public Calificacion save(Calificacion Calificacion) {
        if (Calificacion.getId() == null) {
            return metodosCrud.save(Calificacion);
        } else {
            Optional<Calificacion> e = metodosCrud.getCalificacion(Calificacion.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(Calificacion);
            } else {
                return Calificacion;
            }
        }
    }

    public Calificacion update(Calificacion Calificacion) {
        if (Calificacion.getId() != null) {
            Optional<Calificacion> e = metodosCrud.getCalificacion(Calificacion.getId());
            if (!e.isEmpty()) {
                if (Calificacion.getVr_mensaje()!= null) {
                    e.get().setVr_mensaje(Calificacion.getVr_mensaje());
                }
                if (Calificacion.getVr_reserva()!= null) {
                    e.get().setVr_reserva(Calificacion.getVr_reserva());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Calificacion;
            }
        } else {
            return Calificacion;
        }
    }

    public boolean deleteCalificacion(int CalificacionId) {
        Boolean aBoolean = getCalificacion(CalificacionId).map(Calificacion -> {
            metodosCrud.delete(Calificacion);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
