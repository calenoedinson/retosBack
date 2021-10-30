package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Cabana;
import co.usa.ciclo3.ciclo3.service.CabanaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabanaController {

    @Autowired
    private CabanaService servicio;

    @GetMapping("/all")
    public List<Cabana> getCabanas() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cabana> getCabanas(@PathVariable("id") int CabanaId) {
        return servicio.getCabana(CabanaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabana save(@RequestBody Cabana Cabana) {
        return servicio.save(Cabana);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabana update(@RequestBody Cabana Cabana) {
        return servicio.update(Cabana);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int CabanaId) {
        System.out.println(CabanaId);
        return servicio.deleteCabana(CabanaId);
    }
}
