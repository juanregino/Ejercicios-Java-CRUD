package controller;

import entity.Vuelo;
import model.VueloModel;

import java.sql.Time;


import java.sql.Date;

import java.util.List;
import java.util.Scanner;


public class VueloController {
    VueloModel objVueloMod = new VueloModel();


    public void listVuelos (){
        List<Vuelo > listTemp = objVueloMod.listarVuelos();
        for (Vuelo vueloTemp : listTemp){
            System.out.println(vueloTemp.toString() + "\n");
        }
    }

    public void agregarVuelo(Scanner scanner, String idAvion){
        Vuelo objVuelo = new Vuelo();

        System.out.println("Ingrese el destino");
        String destino = scanner.next();

        Date fechaString = null;

        try {
            System.out.println("Ingrese la fecha del vuelo (en formato YYYY-MM-DD): ");
            fechaString = Date.valueOf(scanner.next());

        }catch (Exception e){
            System.out.println("Fecha incorrecta.");
        }


        // Mostrar la fecha ingresada

        System.out.println("Ingrese la hora del vuelo (en formato HH:MM:SS 24hrs): ");
        String horaString = scanner.next();

        // Convertir la cadena de entrada a un objeto Time
        Time hora = Time.valueOf(horaString);

        // Mostrar la hora ingresada
        System.out.println("La hora del vuelo ingresada es: " + hora);
        objVuelo.setId(String.valueOf(System.currentTimeMillis()));

       objVuelo.setDestino(destino);
       objVuelo.setFechaSalida(fechaString);
       objVuelo.setHoraSalida(hora);
       objVuelo.setIdAvion(idAvion);

       objVueloMod.agregarVuelo(objVuelo);
    }

    public void buscarVueloPorID(Scanner scanner){
        this.listVuelos();
        System.out.println("Ingrese el id del vuelo");
        String id = scanner.next();

        Vuelo objVuelo = objVueloMod.buscarPorId(id);
        System.out.println(objVuelo.toString());

    }

    public void actualizarVuelo (Scanner scanner){
        AvionController objAvionCont = new AvionController();
        this.listVuelos();
        System.out.println("Ingrese el id del vuelo que vas a actualizar");
        String idAct = scanner.next();
        System.out.println("idAct "+idAct);

        Vuelo objVuelo = objVueloMod.buscarPorId(idAct);
        System.out.println("objVuelo "+objVuelo);


        System.out.println("Actualice el destino" + objVuelo.getDestino());
        String destino = scanner.next();

        Date fechaString = null;

        try {
            System.out.println("Actualice la fecha del vuelo (en formato YYYY-MM-DD): ");
            fechaString = Date.valueOf(scanner.next());

        }catch (Exception e){
            System.out.println("Fecha incorrecta.");
        }


        // Mostrar la fecha ingresada

        System.out.println("Actualice la hora del vuelo (en formato HH:MM:SS 24hrs): ");
        String horaString = scanner.next();

        // Convertir la cadena de entrada a un objeto Time
        Time hora = Time.valueOf(horaString);

        // Mostrar la hora ingresada
        System.out.println("La hora del vuelo ingresada es: " + hora);
        objVuelo.setId(String.valueOf(System.currentTimeMillis()));


         objAvionCont.listAviones();
        System.out.println("Ingrese el id del avion que vas a actualizar");
        String idAvion = scanner.next();

        objVuelo.setDestino(destino);
        objVuelo.setFechaSalida(fechaString);
        objVuelo.setHoraSalida(hora);
        objVuelo.setIdAvion(idAvion);


    }

    public void eliminarVuelo (Scanner scanner){
        this.listVuelos();

        System.out.println("ingrese el id quie va a eliminar");
        String id = scanner.next();

        objVueloMod.borrarVuelo(id);
    }
}
