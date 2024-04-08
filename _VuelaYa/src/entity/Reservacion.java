package entity;

import java.sql.Date;

public class Reservacion {
    private String id;
    private String idPasajero;
    private String idVuelo;
    private Date fechaReservacion ;
    private String asiento ;
    private Vuelo vuelo ;

    private Pasajero pasajero;

    public Reservacion() {
    }

    public Reservacion(String id, String idPasajero, String idVuelo, Date fechaReservacion, String asiento, Vuelo vuelo, Pasajero pasajero) {
        this.id = id;
        this.idPasajero = idPasajero;
        this.idVuelo = idVuelo;
        this.fechaReservacion = fechaReservacion;
        this.asiento = asiento;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(String idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    @Override
    public String toString() {
        return "Reservacion{" +
                "id='" + id + '\'' +
                ", idPasajero='" + idPasajero + '\'' +
                ", idVuelo='" + idVuelo + '\'' +
                ", fechaReservacion=" + fechaReservacion +
                ", asiento='" + asiento + '\'' +
                ", vuelo=" + vuelo +
                ", pasajero=" + pasajero +
                '}';
    }
}
