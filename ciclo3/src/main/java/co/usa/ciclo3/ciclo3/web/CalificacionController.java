package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Calificacion;
import co.usa.ciclo3.ciclo3.service.CalificacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CalificacionController {

    @Autowired
    private CalificacionService servicio;

    @GetMapping("/all")
    public List<Calificacion> getCalificacions() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Calificacion> getCalificacions(@PathVariable("id") int CalificacionId) {
        return servicio.getCalificacion(CalificacionId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion save(@RequestBody Calificacion Calificacion) {
        return servicio.save(Calificacion);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion update(@RequestBody Calificacion Calificacion) {
        return servicio.update(Calificacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int CalificacionId) {
        return servicio.deleteCalificacion(CalificacionId);
    }
}
