package repository;

import entity.Reservacion;

import java.util.List;

public interface ReservacionCRUDRepository {
    void agregarReservacion (Reservacion reservacion);

    Reservacion buscarPorId (String id);

    List<Reservacion> listarReservas ();

    void actualizarReservacion (Reservacion reservacion);

    void borrarReservacion (String id);
}
