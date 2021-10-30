package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.repository.crud.CategoriaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository {

    @Autowired
    private CategoriaCrudRepository CategoriaCrudRepository;

    public List<Categoria> getAll() {
        return (List<Categoria>) CategoriaCrudRepository.findAll();
    }

    public Optional<Categoria> getCategoria(int id) {
        return CategoriaCrudRepository.findById(id);
    }

    public Categoria save(Categoria Categoria) {
        return CategoriaCrudRepository.save(Categoria);
    }

    public void delete(Categoria Categoria) {
        CategoriaCrudRepository.delete(Categoria);
    }

}
