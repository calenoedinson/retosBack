package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Mensaje;
import co.usa.ciclo3.ciclo3.repository.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMensaje(int idMensaje) {
        return metodosCrud.getMensaje(idMensaje);
    }

    public Mensaje save(Mensaje Mensaje) {
        if (Mensaje.getIdMessage()== null) {
            return metodosCrud.save(Mensaje);
        } else {
            Optional<Mensaje> e = metodosCrud.getMensaje(Mensaje.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(Mensaje);
            } else {
                return Mensaje;
            }
        }
    }

    public Mensaje update(Mensaje Mensaje) {
        if (Mensaje.getIdMessage() != null) {
            Optional<Mensaje> e = metodosCrud.getMensaje(Mensaje.getIdMessage());
            if (!e.isEmpty()) {
                if (Mensaje.getMessageText()!= null) {
                    e.get().setMessageText(Mensaje.getMessageText());
                }
                if (Mensaje.getClient()!= null) {
                    e.get().setClient(Mensaje.getClient());
                }
                if (Mensaje.getCabin()!= null) {
                    e.get().setCabin(Mensaje.getCabin());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Mensaje;
            }
        } else {
            return Mensaje;
        }
    }

    public boolean deleteMensaje(int MensajeId) {
        Boolean aBoolean = getMensaje(MensajeId).map(Mensaje -> {
            metodosCrud.delete(Mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
