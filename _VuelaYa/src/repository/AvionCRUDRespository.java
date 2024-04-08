package repository;

import entity.Avion;

import java.util.List;

public interface AvionCRUDRespository {
    void agregarAvion (Avion avion);

    Avion buscarPorId (String id);

    List<Avion> listarAviones ();

    void actualizarAvion (Avion avion);

    void borrarAvion (String id);
}
