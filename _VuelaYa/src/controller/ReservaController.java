package controller;

import entity.Reservacion;
import model.ReservacionModel;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class ReservaController {

    ReservacionModel objReservaMod = new ReservacionModel();

    public void agregarReserva(Scanner scanner, String idVuelo, String idPasajero) {
        Reservacion objReserva = new Reservacion();


        Date fechaString = null;

        try {
            System.out.println("Ingrese la fecha del vuelo (en formato YYYY-MM-DD): ");
            fechaString = Date.valueOf(scanner.next());

        } catch (Exception e) {
            System.out.println("Fecha incorrecta.");
        }


        // Mostrar la fecha ingresada

        System.out.println("Ingrese la hora del vuelo (en formato HH:MM:SS 24hrs): ");
        String horaString = scanner.next();

        // Convertir la cadena de entrada a un objeto Time
        Time hora = Time.valueOf(horaString);

        // Mostrar la hora ingresada
        System.out.println("La hora del vuelo ingresada es: " + hora);

        System.out.println("Que haciento quieres elegir");
        String asiento = scanner.next();
        objReserva.setId(String.valueOf(System.currentTimeMillis()));

        objReserva.setIdPasajero(idPasajero);
        objReserva.setIdVuelo(idVuelo);
        objReserva.setAsiento(asiento);
        objReserva.setFechaReservacion(fechaString);


        objReservaMod.agregarReservacion(objReserva);
    }

    public void listarReservas() {
        List<Reservacion> listTemp = objReservaMod.listarReservas();
        for (Reservacion reservaTemp : listTemp) {
            System.out.println(reservaTemp.toString() + "\n");
        }
    }
public void eliminarReserva (Scanner scanner){
        this.listarReservas();
    System.out.println("ingrese el id de la reserva que va a eliminar ");
    String idDel = scanner.next();

    objReservaMod.borrarReservacion(idDel);
}

public  void buscarPorID(Scanner scanner){
        this.listarReservas();
    System.out.println("ingrese el id de la reserva que va a eliminar ");
    String id = scanner.next();

    Reservacion objReserva = objReservaMod.buscarPorId(id);
    System.out.println(objReserva.toString());

}
public void actualizarReserva (Scanner scanner, String idPasajero , String idVuelo){
       this.listarReservas();
    System.out.println("ingrese el id de la reserva que va a actualizar ");
    String idAct = scanner.next();
    Reservacion objReservaAct = objReservaMod.buscarPorId(idAct);


    Date fechaString = null;

    try {
        System.out.println("Ingrese la fecha de la reserva (en formato YYYY-MM-DD): ");
        fechaString = Date.valueOf(scanner.next());

    } catch (Exception e) {
        System.out.println("Fecha incorrecta.");
    }


    // Mostrar la fecha ingresada



    System.out.println("Que haciento quieres elegir");
    String asiento = scanner.next();


    objReservaAct.setIdPasajero(idPasajero);
    objReservaAct.setIdVuelo(idVuelo);
    objReservaAct.setAsiento(asiento);
    objReservaAct.setFechaReservacion(fechaString);


    objReservaMod.actualizarReservacion(objReservaAct);
}
}
