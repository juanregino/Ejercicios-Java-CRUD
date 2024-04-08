package entity;

import java.sql.Time;
import java.sql.Date;

public class Vuelo {

    private String id;

    private String destino ;
    private Date fechaSalida;

    private Time horaSalida;

    private String idAvion;

    private Avion avion ;

    public Vuelo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "vuelo{" +
                "id='" + id + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", horaSalida=" + horaSalida +

                ", Modelo del avion=" + avion.getModelo() +
                ", Capacidad=" + avion.getCapacidad() +
                '}';
    }
}
