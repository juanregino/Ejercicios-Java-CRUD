package controller;

import entity.Avion;
import model.AvionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class AvionController {

    AvionModel objAvionMod = new AvionModel();

    public void listAviones (){
        List<Avion> listTemp = objAvionMod.listarAviones();
        for (Avion aviontemp : listTemp){
            System.out.println(aviontemp.toString()  + "\n");
        }
    }

    public void agregarAvion (Scanner scanner){

        Avion objAvion = new Avion();

        System.out.println("Inserte el modelo del avion");
        String modelo = scanner.next();

        System.out.println("Inserte la capacidad de pasajeros del Avion");
        int capacidad = scanner.nextInt();

        String id = String.valueOf(System.currentTimeMillis());
        System.out.println(id);
        objAvion.setId(id);
        objAvion.setModelo(modelo);
        objAvion.setCapacidad(capacidad);

        objAvionMod.agregarAvion(objAvion);
    }

    public void actualizarAvion(Scanner scanner){
     this.listAviones();
        System.out.println("ingrese el id del avion que quiere actualizar");
        String idAct = scanner.next();

        Avion objAvionAct = objAvionMod.buscarPorId(idAct);
        System.out.println("Inserte el modelo del avion");
        String modelo = scanner.next();

        System.out.println("Inserte la capacidad de pasajeros del Avion");
        int capacidad = scanner.nextInt();

        objAvionAct.setModelo(modelo);
        objAvionAct.setCapacidad(capacidad);

        objAvionMod.actualizarAvion(objAvionAct);


    }

    public  void  borrarAvion(Scanner scanner){
        System.out.println("ingrese el id del avion que quiere borrar");
        String idDel = scanner.next();
       objAvionMod.borrarAvion(idDel);
        System.out.println("avion borrado exitosamente");
    }

    public void  buscarAvionPorID (Scanner scanner){
        this.listAviones();
        System.out.println("ingrese el id del avion que quiere buscar");
        String id = scanner.next();
        Avion objAvion = objAvionMod.buscarPorId(id);

        if (objAvion == null){
            System.out.println("No se encontro un avion con ese id");
        }else {
            System.out.println(objAvion.toString());
        }
    }
}
