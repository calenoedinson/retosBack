package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Cabana;
import co.usa.ciclo3.ciclo3.repository.CabanaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabanaService {

    @Autowired
    private CabanaRepository metodosCrud;

    public List<Cabana> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cabana> getCabana(int idCabana) {
        return metodosCrud.getCabana(idCabana);
    }

    public Cabana save(Cabana Cabana) {
        if (Cabana.getId() == null) {
            return metodosCrud.save(Cabana);
        } else {
            Optional<Cabana> e = metodosCrud.getCabana(Cabana.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(Cabana);
            } else {
                return Cabana;
            }
        }
    }

    public Cabana update(Cabana Cabana) {
        if (Cabana.getId() != null) {
            Optional<Cabana> e = metodosCrud.getCabana(Cabana.getId());
            if (!e.isEmpty()) {
                if (Cabana.getBrand() != null) {
                    e.get().setBrand(Cabana.getBrand());
                }
                if (Cabana.getRooms()!= null) {
                    e.get().setRooms(Cabana.getRooms());
                }
                if (Cabana.getCategory()!= null) {
                    e.get().setCategory(Cabana.getCategory());
                }
                if (Cabana.getName()!= null) {
                    e.get().setName(Cabana.getName());
                }
                if (Cabana.getDescription()!= null) {
                    e.get().setDescription(Cabana.getDescription());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Cabana;
            }
        } else {
            return Cabana;
        }
    }

    public boolean deleteCabana(int CabanaId) {
        Boolean aBoolean = getCabana(CabanaId).map(Cabana -> {
            metodosCrud.delete(Cabana);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
