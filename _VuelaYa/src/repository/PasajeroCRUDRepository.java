package repository;

import entity.Pasajero;

import java.util.List;

public interface PasajeroCRUDRepository {
    void agregarPasajero (Pasajero pasajero);

    Pasajero buscarPorId (String id);

    List<Pasajero> listarPasajeros ();

    void actualizarPasajero (Pasajero pasajero);

    void borrarPasajero (String id);
}
