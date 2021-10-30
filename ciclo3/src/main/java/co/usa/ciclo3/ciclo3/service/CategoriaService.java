package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int idCategoria) {
        return metodosCrud.getCategoria(idCategoria);
    }

    public Categoria save(Categoria Categoria) {
        if (Categoria.getId() == null) {
            return metodosCrud.save(Categoria);
        } else {
            Optional<Categoria> e = metodosCrud.getCategoria(Categoria.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(Categoria);
            } else {
                return Categoria;
            }
        }
    }

    public Categoria update(Categoria Categoria) {
        if (Categoria.getId() != null) {
            Optional<Categoria> e = metodosCrud.getCategoria(Categoria.getId());
            if (!e.isEmpty()) {
                if (Categoria.getName()!= null) {
                    e.get().setName(Categoria.getName());
                }
                if (Categoria.getDescription()!= null) {
                    e.get().setDescription(Categoria.getDescription());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Categoria;
            }
        } else {
            return Categoria;
        }
    }

    public boolean deleteCategoria(int CategoriaId) {
        Boolean aBoolean = getCategoria(CategoriaId).map(Categoria -> {
            metodosCrud.delete(Categoria);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
