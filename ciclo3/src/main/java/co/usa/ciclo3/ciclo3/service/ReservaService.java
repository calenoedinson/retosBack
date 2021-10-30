package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reserva;
import co.usa.ciclo3.ciclo3.reportes.ContadorClientes;
import co.usa.ciclo3.ciclo3.reportes.StatusReservas;
import co.usa.ciclo3.ciclo3.repository.ReservaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository metodosCrud;

    public List<Reserva> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reserva> getReserva(int idReserva) {
        return metodosCrud.getReserva(idReserva);
    }

    public Reserva save(Reserva Reserva) {
        if (Reserva.getIdReservation() == null) {
            return metodosCrud.save(Reserva);
        } else {
            Optional<Reserva> e = metodosCrud.getReserva(Reserva.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(Reserva);
            } else {
                return Reserva;
            }
        }
    }

    public Reserva update(Reserva Reserva) {
        if (Reserva.getIdReservation() != null) {
            Optional<Reserva> e = metodosCrud.getReserva(Reserva.getIdReservation());
            if (!e.isEmpty()) {
                if (Reserva.getStartDate() != null) {
                    e.get().setStartDate(Reserva.getStartDate());
                }
                if (Reserva.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(Reserva.getDevolutionDate());
                }
                if (Reserva.getClient() != null) {
                    e.get().setClient(Reserva.getClient());
                }
                if (Reserva.getCabin() != null) {
                    e.get().setCabin(Reserva.getCabin());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return Reserva;
            }
        } else {
            return Reserva;
        }
    }

    public boolean deleteReserva(int ReservaId) {
        Boolean aBoolean = getReserva(ReservaId).map(Reserva -> {
            metodosCrud.delete(Reserva);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservas getReporteStatusReservaciones() {
        List<Reserva> completed = metodosCrud.ReservacionStatus("completed");
        List<Reserva> cancelled = metodosCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reserva> getReportesTiempoReservaciones(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return metodosCrud.ReservacionTiempo(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }

    public List<ContadorClientes> servicioTopClientes() {
        return metodosCrud.getTopClientes();
    }
}
