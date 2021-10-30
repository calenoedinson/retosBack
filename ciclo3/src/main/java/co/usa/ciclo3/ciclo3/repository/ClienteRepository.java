package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.repository.crud.ClienteCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    public Optional<Cliente> getCliente(int id) {
        return clienteCrudRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteCrudRepository.save(cliente);
    }

    public void delete(Cliente cliente) {
        clienteCrudRepository.delete(cliente);
    }

}
