package model;

import database.ConfigDB;
import entity.Avion;
import entity.Pasajero;
import entity.Reservacion;
import entity.Vuelo;
import repository.ReservacionCRUDRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservacionModel implements ReservacionCRUDRepository {
    @Override
    public void agregarReservacion(Reservacion reservacion) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        //try-catch ya que puede fallar
        try {
            //2. Sentencia SQL
            String sql = "INSERT INTO reservacion (id,idPasajero,idVuelo,fechaReservacion,asiento) VALUES(?,?,?,?,?)";
            //3. Preparar e statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //Asignar los '?'
            objPrepared.setString(1, reservacion.getId());
            objPrepared.setString(2, reservacion.getIdPasajero());
            objPrepared.setString(3, reservacion.getIdVuelo());
            objPrepared.setDate(4, reservacion.getFechaReservacion());
            objPrepared.setString(5, reservacion.getAsiento());

            //4. Ejecutamos el query o 'consulta'
            objPrepared.execute();

            System.out.println("Reserva insertada correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Cerrar la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public Reservacion buscarPorId(String id) {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();

        Vuelo objVuelo = new Vuelo();
        Avion objAvion = new Avion();
        Reservacion objReserva = new Reservacion();
        Pasajero objPasajero = new Pasajero();
        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM reservacion\n" +
                    "inner join pasajero on reservacion.idPasajero = pasajero.id \n" +
                    "inner join vuelo on reservacion.idVuelo = vuelo.id \n" +
                    "inner join avion on vuelo.idAvion = avion.id where reservacion.id = ?; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);
            //5. Damos valor al '?'
            objPrepared.setString(1, id);
            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                //Llenamos los datos de la reserva
                objReserva.setId(objResult.getString("reservacion.id"));
                objReserva.setIdPasajero(objResult.getString("reservacion.idPasajero"));
                objReserva.setIdVuelo(objResult.getString("reservacion.idVuelo"));
                objReserva.setFechaReservacion(objResult.getDate("reservacion.fechaReservacion"));
                objReserva.setAsiento(objResult.getString("reservacion.asiento"));
                //LLenamos los datos del reservacion
                objVuelo.setId(objResult.getString("id"));
                objVuelo.setDestino(objResult.getString("destino"));
                objVuelo.setFechaSalida(objResult.getDate("fechaSalida"));
                objVuelo.setHoraSalida(objResult.getTime("horaSalida"));
                objVuelo.setIdAvion(objResult.getString("idAvion"));

                //LLenamos los datos del avion

                objAvion.setId(objResult.getString("avion.id"));
                objAvion.setModelo(objResult.getString("avion.modelo"));
                objAvion.setCapacidad(objResult.getInt("avion.capacidad"));
                objVuelo.setAvion(objAvion);

                //Llenamos los datos del pasajero
                objPasajero.setId(objResult.getString("pasajero.id"));
                objPasajero.setName(objResult.getString("pasajero.nombre"));
                objPasajero.setApellido(objResult.getString("pasajero.apellido"));
                objPasajero.setDocumentoIdentidad(objResult.getString("pasajero.documentoIdentidad"));

                //asignamos el reservacion y el pasajero a la reservacion
                objReserva.setPasajero(objPasajero);
                objReserva.setVuelo(objVuelo);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objReserva;
    }

    @Override
    public List<Reservacion> listarReservas() {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();

        Vuelo objVuelo = new Vuelo();
        Avion objAvion = new Avion();
        Reservacion objReserva = new Reservacion();
        Pasajero objPasajero = new Pasajero();
        List<Reservacion> listReservas = new ArrayList<>();
        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM reservacion  \n" +
                    "inner join pasajero on reservacion.idPasajero = pasajero.id \n" +
                    "inner join vuelo on reservacion.idVuelo = vuelo.id \n" +
                    "inner join avion on vuelo.idAvion = avion.id; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                //Llenamos los datos de la reserva
                objReserva.setId(objResult.getString("reservacion.id"));
                objReserva.setIdPasajero(objResult.getString("reservacion.idPasajero"));
                objReserva.setIdVuelo(objResult.getString("reservacion.idVuelo"));
                objReserva.setFechaReservacion(objResult.getDate("reservacion.fechaReservacion"));
                objReserva.setAsiento(objResult.getString("reservacion.asiento"));
                //LLenamos los datos del reservacion
                objVuelo.setId(objResult.getString("id"));
                objVuelo.setDestino(objResult.getString("destino"));
                objVuelo.setFechaSalida(objResult.getDate("fechaSalida"));
                objVuelo.setHoraSalida(objResult.getTime("horaSalida"));
                objVuelo.setIdAvion(objResult.getString("idAvion"));

                //LLenamos los datos del avion

                objAvion.setId(objResult.getString("avion.id"));
                objAvion.setModelo(objResult.getString("avion.modelo"));
                objAvion.setCapacidad(objResult.getInt("avion.capacidad"));
                objVuelo.setAvion(objAvion);

                //Llenamos los datos del pasajero
                objPasajero.setId(objResult.getString("pasajero.id"));
                objPasajero.setName(objResult.getString("pasajero.nombre"));
                objPasajero.setApellido(objResult.getString("pasajero.apellido"));
                objPasajero.setDocumentoIdentidad(objResult.getString("pasajero.documentoIdentidad"));

                //asignamos el reservacion y el pasajero a la reservacion
                objReserva.setPasajero(objPasajero);
                objReserva.setVuelo(objVuelo);
                listReservas.add(objReserva);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listReservas;
    }

    @Override
    public void actualizarReservacion(Reservacion reservacion) {
//1. Abro la conexion
        Connection objConnection = ConfigDB.openConnection();
        System.out.println(reservacion.toString());
        //Try-catch ya que puede fallar
        try {
            //2. Sentencia sql
            String sql = "UPDATE reservacion SET idPasajero = ? , idVuelo = ? , fechaReservacion = ?, asiento = ?  WHERE reservacion.id = ? ;";
            //3. Preparar el estado
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            // 4. Damos valor a '?'
            objPrepared.setString(1, reservacion.getIdPasajero());
            objPrepared.setString(2, reservacion.getIdVuelo());
            objPrepared.setDate(3, reservacion.getFechaReservacion());
            objPrepared.setString(4, reservacion.getAsiento());
            objPrepared.setString(5, reservacion.getId());

            //5. Ejecutamos el query
            int rowAffect = objPrepared.executeUpdate();
            System.out.println(rowAffect);
            if (rowAffect > 0) {
                System.out.println("Se actualizo correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //6. Cerramos la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public void borrarReservacion(String id) {
//1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        // Try-catch ya que puede fallar

        try {
            //2. Escribir la sentencia sql
            String sql = "DELETE FROM reservacion WHERE id = ? ;";
            //3. Preparamos el statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //4. Asignamos el valor al ?
            objPrepared.setString(1, id);

            //5. Ejecutamos el query
            objPrepared.execute();

            System.out.println("Eliminado exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //6. Cerramos la conexión
        ConfigDB.closeConnection();
    }
}
