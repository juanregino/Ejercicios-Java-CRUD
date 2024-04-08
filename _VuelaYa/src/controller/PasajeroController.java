package controller;

import entity.Pasajero;

import model.PasajeroModel;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PasajeroController {
    PasajeroModel objPasajeroMod = new PasajeroModel();

    public void listPasajeros() {
        List<Pasajero> listTemp = objPasajeroMod.listarPasajeros();
        for (Pasajero pasajeroTemp : listTemp) {
            System.out.println(pasajeroTemp.toString() + "\n");
        }
    }

    public void agregarPasajeros(Scanner scanner) {

        Pasajero objPasajero = new Pasajero();

        System.out.println("Inserte el nombre del pasajero");
        String nombre = scanner.next();

        System.out.println("Inserte el apellido del Pasajero");
        String apellido = scanner.next();

        String id = String.valueOf(System.currentTimeMillis());

        System.out.println("Inserte el documento de identidad del Pasajero");
        String documento = scanner.next();

        objPasajero.setId(id);
        objPasajero.setName(nombre);
        objPasajero.setApellido(apellido);
        objPasajero.setDocumentoIdentidad(documento);

        objPasajeroMod.agregarPasajero(objPasajero);
    }

    public void actualizarPasajero(Scanner scanner) {
        this.listPasajeros();
        System.out.println("ingrese el id del pasajero que quiere actualizar");
        String idAct = scanner.next();

        Pasajero objPasajeroAct = objPasajeroMod.buscarPorId(idAct);
        System.out.println("Inserte el nombre del pasajero");
        String nombre = scanner.next();

        System.out.println("Inserte el apellido del Pasajero");
        String apellido = scanner.next();


        System.out.println("Inserte el documento de identidad del Pasajero");
        String documento = scanner.next();
        objPasajeroAct.setName(nombre);
        objPasajeroAct.setApellido(apellido);
        objPasajeroAct.setDocumentoIdentidad(documento);
        objPasajeroMod.actualizarPasajero(objPasajeroAct);


    }

    public void borrarPasajero(Scanner scanner) {
        System.out.println("ingrese el id del pasajero que quiere borrar");
        String idDel = scanner.next();
        objPasajeroMod.borrarPasajero(idDel);
        System.out.println("pasajero borrado exitosamente");
    }

    public void buscarPasajeroPorID(Scanner scanner) {
        System.out.println("ingrese el id del pasajero que quiere buscar");
        String id = scanner.next();
        Pasajero objPasajero = objPasajeroMod.buscarPorId(id);

        if (objPasajero == null) {
            System.out.println("No se encontro un pasajero con ese id");
        } else {
            System.out.println(objPasajero.toString());
        }
    }
}
