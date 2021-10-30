package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    private ClienteService servicio;

    @GetMapping("/all")
    public List<Cliente> getClientes() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClientes(@PathVariable("id") int ClienteId) {
        return servicio.getCliente(ClienteId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente Cliente) {
        return servicio.save(Cliente);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente Cliente) {
        return servicio.update(Cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ClienteId) {
        return servicio.deleteCliente(ClienteId);
    }
}
