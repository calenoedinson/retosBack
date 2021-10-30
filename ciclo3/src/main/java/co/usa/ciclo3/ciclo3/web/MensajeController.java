package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Mensaje;
import co.usa.ciclo3.ciclo3.service.MensajeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MensajeController {

    @Autowired
    private MensajeService servicio;

    @GetMapping("/all")
    public List<Mensaje> getMensajes() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMensajes(@PathVariable("id") int MensajeId) {
        return servicio.getMensaje(MensajeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje Mensaje) {
        return servicio.save(Mensaje);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje Mensaje) {
        return servicio.update(Mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int MensajeId) {
        return servicio.deleteMensaje(MensajeId);
    }
}
