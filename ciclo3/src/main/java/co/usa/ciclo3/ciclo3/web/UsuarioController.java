package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Usuario;
import co.usa.ciclo3.ciclo3.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/all")
    public List<Usuario> getUsuarios() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarios(@PathVariable("id") int UsuarioId) {
        return servicio.getUsuario(UsuarioId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario Usuario) {
        return servicio.save(Usuario);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario Usuario) {
        return servicio.update(Usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int UsuarioId) {
        return servicio.deleteUsuario(UsuarioId);
    }
}
