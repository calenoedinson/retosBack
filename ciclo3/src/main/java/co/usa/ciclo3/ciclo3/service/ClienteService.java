package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getCliente(int idCliente) {
        return metodosCrud.getCliente(idCliente);
    }

    public Cliente save(Cliente Cliente) {
        if (Cliente.getIdClient() == null) {
            return metodosCrud.save(Cliente);
        } else {
            Optional<Cliente> e = metodosCrud.getCliente(Cliente.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(Cliente);
            } else {
                return Cliente;
            }
        }
    }

    public Cliente update(Cliente Cliente) {
        if (Cliente.getIdClient()!= null) {
            Optional<Cliente> e = metodosCrud.getCliente(Cliente.getIdClient());
            if (!e.isEmpty()) {
                if (Cliente.getName()!= null) {
                    e.get().setName(Cliente.getName());
                }
                if (Cliente.getEmail()!= null) {
                    e.get().setEmail(Cliente.getEmail());
                }
                if (Cliente.getPassword()!= null) {
                    e.get().setPassword(Cliente.getPassword());
                }
                if (Cliente.getAge()!= null) {
                    e.get().setAge(Cliente.getAge());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Cliente;
            }
        } else {
            return Cliente;
        }
    }

    public boolean deleteCliente(int ClienteId) {
        Boolean aBoolean = getCliente(ClienteId).map(Cliente -> {
            metodosCrud.delete(Cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
