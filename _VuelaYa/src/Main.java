import controller.AvionController;
import controller.PasajeroController;
import controller.ReservaController;
import controller.VueloController;
import database.ConfigDB;
import entity.Pasajero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AvionController objAvionController = new AvionController();
        PasajeroController objPasajeroCont = new PasajeroController();
        VueloController objVueloCont = new VueloController();
        ReservaController objReservaCont = new ReservaController();
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        int optionAvion = -1;
        int optionPasajero = -1;
        int optionVuelo = -1;
        int optionReserva = -1;
        do {
            System.out.println("""
                    BIENVENIDO A VUELAYA 
                                        
                    1. Gestionar Aviones
                    2. Gestionar Pasajeros
                    3. Gestionar Vuelos
                    4. Gestionar Reservas
                    
                                        
                    """);
            System.out.println("ingresa la opcion >>");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    do {
                        System.out.println("""
                                GESTIONANDO UN AVION
                                                                
                                1. Agregar un Avion
                                2. Listar Aviones
                                3. Listar Avion por ID
                                4. Actualizar Avion
                                5. Eliminar Avion
                                6. Salir
                                                                
                                """);

                        optionAvion = scanner.nextInt();

                        switch (optionAvion) {
                            case 1:
                                objAvionController.agregarAvion(scanner);
                                break;

                            case 2:
                                objAvionController.listAviones();
                                break;
                            case 3:
                                objAvionController.buscarAvionPorID(scanner);
                                break;
                            case 4:
                                objAvionController.actualizarAvion(scanner);
                                break;
                            case 5:
                                objAvionController.borrarAvion(scanner);
                                break;
                        }
                    } while (optionAvion != 6);
                    break;

                case 2:
                    do {
                        System.out.println("""
                                GESTIONANDO UN PASAJERO
                                                                
                                1. Agregar un Pasajero
                                2. Listar Pasajero
                                3. Listar Pasajero por ID
                                4. Actualizar Pasajero
                                5. Eliminar Pasajero
                                6. Salir
                                                                
                                """);

                        System.out.println("Ingrese la opcion >>");
                        optionPasajero = scanner.nextInt();

                        switch (optionPasajero) {
                            case 1:
                                objPasajeroCont.agregarPasajeros(scanner);
                                break;

                            case 2:
                                objPasajeroCont.listPasajeros();
                                break;
                            case 3:

                                objPasajeroCont.buscarPasajeroPorID(scanner);
                                break;
                            case 4:

                                objPasajeroCont.actualizarPasajero(scanner);
                                break;
                            case 5:

                                objPasajeroCont.borrarPasajero(scanner);
                                break;
                        }


                    } while (optionPasajero != 6);
                    break;

                case 3:

                    do {
                        System.out.println("""
                                GESTIONANDO VUELOS
                                                                
                                1. Agregar un Vuelo
                                2. Listar Vuelo
                                3. Buscar Vuelo por ID
                                4. Actualizar Vuelo
                                5. Eliminar Vuelo
                                6. Salir
                                """);
                        System.out.println("Ingrese la opcion >>");
                        optionVuelo = scanner.nextInt();
                  switch (optionVuelo) {

                      case 1:
                      objAvionController.listAviones();
                      System.out.println("Ingresa el id del avion que vas a asignar a este vuelo");
                      String idAvion = scanner.next();
                      objVueloCont.agregarVuelo(scanner, idAvion);
                      break;

                      case 2 :
                          objVueloCont.listVuelos();
                          break;

                      case 3 :
                          objVueloCont.buscarVueloPorID(scanner);
                          break;
                      case 4 :
                          objVueloCont.actualizarVuelo(scanner);
                          break;
                      case 5 :
                          objVueloCont.eliminarVuelo(scanner);
                          break;

                  }
                    }while (optionVuelo != 6);

                   break;

                case 4 :
                    do {
                        System.out.println("""
                                GESTIONANDO RESERVAS
                                                                
                                1. Agregar un Reserva
                                2. Listar Reserva
                                3. Buscar Reserva por ID
                                4. Actualizar Reserva
                                5. Eliminar Reserva
                                6. Salir
                                """);
                        System.out.println("Ingrese la opcion >>");
                        optionReserva = scanner.nextInt();
                        switch (optionReserva) {

                            case 1:
                                objVueloCont.listVuelos();
                                System.out.println("Ingresa el id del vuelo que vas a asignar a esta reserva");
                                String idVuelo = scanner.next();
                                objPasajeroCont.listPasajeros();
                                System.out.println("Ingresa el id del vuelo que vas a asignar a esta reserva");
                                String idPasajero = scanner.next();
                                objReservaCont.agregarReserva(scanner, idVuelo, idPasajero);
                                break;

                            case 2 :
                                objReservaCont.listarReservas();
                                break;

                            case 3 :
                                objReservaCont.buscarPorID(scanner);
                                break;
                            case 4 :
                                System.out.println("Vuelos disponibles");
                                objVueloCont.listVuelos();
                                System.out.println("Ingresa el id del vuelo que vas a actualizar a esta reserva");
                                String idVueloAct = scanner.next();
                                objPasajeroCont.listPasajeros();
                                System.out.println("Ingresa el id del pasajero que vas a actualizar a esta reserva");
                                String idPasajeroAct = scanner.next();
                                objReservaCont.actualizarReserva(scanner,idVueloAct, idPasajeroAct);
                                break;
                            case 5 :
                                objReservaCont.eliminarReserva(scanner);
                                break;

                        }
                    }while (optionReserva != 6);
                    break;
            }
        } while (option != 5);
    }
}