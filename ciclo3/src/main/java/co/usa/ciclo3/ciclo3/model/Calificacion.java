package co.usa.ciclo3.ciclo3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer puntuacion;
    private String vr_mensaje;
    private Integer vr_reserva;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getVr_mensaje() {
        return vr_mensaje;
    }

    public void setVr_mensaje(String vr_mensaje) {
        this.vr_mensaje = vr_mensaje;
    }

    public Integer getVr_reserva() {
        return vr_reserva;
    }

    public void setVr_reserva(Integer vr_reserva) {
        this.vr_reserva = vr_reserva;
    }

       
}
