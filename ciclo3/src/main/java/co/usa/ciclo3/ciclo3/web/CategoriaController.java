package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Categoria;
import co.usa.ciclo3.ciclo3.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriaController {

    @Autowired
    private CategoriaService servicio;

    @GetMapping("/all")
    public List<Categoria> getCategorias() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategorias(@PathVariable("id") int CategoriaId) {
        return servicio.getCategoria(CategoriaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria Categoria) {
        return servicio.save(Categoria);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria Categoria) {
        return servicio.update(Categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int CategoriaId) {
        return servicio.deleteCategoria(CategoriaId);
    }
}
