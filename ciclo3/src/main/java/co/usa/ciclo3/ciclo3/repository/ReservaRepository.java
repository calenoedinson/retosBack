package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Cliente;
import co.usa.ciclo3.ciclo3.model.Reserva;
import co.usa.ciclo3.ciclo3.reportes.ContadorClientes;
import co.usa.ciclo3.ciclo3.repository.crud.ReservaCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getAll() {
        return (List<Reserva>) reservaCrudRepository.findAll();
    }

    public Optional<Reserva> getReserva(int id) {
        return reservaCrudRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaCrudRepository.save(reserva);
    }

    public void delete(Reserva reserva) {
        reservaCrudRepository.delete(reserva);
    }
    
    public List<Reserva> ReservacionStatus (String status){
         return reservaCrudRepository.findAllByStatus(status);
     }
     
     public List<Reserva> ReservacionTiempo (Date a, Date b){
         return reservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
   
     public List<ContadorClientes> getTopClientes(){
         List<ContadorClientes> res=new ArrayList<>();
         List<Object[]>report = reservaCrudRepository.countTotalReservationsByClient();
         for(int i=0; i<report.size();i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         
         }
         return res;
     }

}
