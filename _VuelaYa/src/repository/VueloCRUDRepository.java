package repository;

import entity.Vuelo;

import java.util.List;

public interface VueloCRUDRepository {
    void agregarVuelo (Vuelo vuelo);

    Vuelo buscarPorId (String id);

    List<Vuelo> listarVuelos ();

    void actualizarVuelo (Vuelo vuelo);

    void borrarVuelo (String id);
}
