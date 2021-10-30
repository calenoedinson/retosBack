package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Cabana;
import co.usa.ciclo3.ciclo3.repository.crud.CabanaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CabanaRepository {

    @Autowired
    private CabanaCrudRepository cabanaCrudRepository;

    public List<Cabana> getAll() {
        return (List<Cabana>) cabanaCrudRepository.findAll();
    }

    public Optional<Cabana> getCabana(int id) {
        return cabanaCrudRepository.findById(id);
    }

    public Cabana save(Cabana cabana) {
        return cabanaCrudRepository.save(cabana);
    }

    public void delete(Cabana cabana) {
        cabanaCrudRepository.delete(cabana);
    }

}
