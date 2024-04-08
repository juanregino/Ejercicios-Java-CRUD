package model;

import database.ConfigDB;

import entity.Pasajero;

import repository.PasajeroCRUDRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class PasajeroModel implements PasajeroCRUDRepository {

    @Override
    public void agregarPasajero(Pasajero pasajero) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        //try-catch ya que puede fallar
        try {
            //2. Sentencia SQL
            String sql = "INSERT INTO pasajero (id,nombre,apellido,documentoIdentidad) VALUES(?,?,?,?);";
            //3. Preparar e statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //Asignar los '?'
            objPrepared.setString(1, pasajero.getId());
            objPrepared.setString(2, pasajero.getName());
            objPrepared.setString(3, pasajero.getApellido());
            objPrepared.setString(4, pasajero.getDocumentoIdentidad());

            //4. Ejecutamos el query o 'consulta'
            objPrepared.execute();

            System.out.println("Pasajero agregado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Cerrar la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public Pasajero buscarPorId(String id) {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();

        Pasajero objPasajero = new Pasajero();

        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM pasajero  WHERE id = ?; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);
            //5. Damos valor al '?'
            objPrepared.setString(1, id);
            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                objPasajero.setId(objResult.getString("id"));
                objPasajero.setName(objResult.getString("nombre"));
                objPasajero.setApellido(objResult.getString("apellido"));
                objPasajero.setDocumentoIdentidad(objResult.getString("documentoIdentidad"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPasajero;
    }

    @Override
    public List<Pasajero> listarPasajeros() {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();

        Pasajero objPasajero = new Pasajero();

        List<Pasajero> listPasajeros = new ArrayList<>();

        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM pasajero ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {

                objPasajero.setId(objResult.getString("id"));
                objPasajero.setName(objResult.getString("nombre"));
                objPasajero.setApellido(objResult.getString("apellido"));
                objPasajero.setDocumentoIdentidad(objResult.getString("documentoIdentidad"));


                listPasajeros.add(objPasajero);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listPasajeros;
    }

    @Override
    public void actualizarPasajero(Pasajero pasajero) {
//1. Abro la conexion
        Connection objConnection = ConfigDB.openConnection();
        //Try-catch ya que puede fallar
        try {
            //2. Sentencia sql
            String sql = "UPDATE pasajero SET nombre = ? , apellido = ? , documentoIdentidad = ?  WHERE id = ? ;";
            //3. Preparar el estado
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            // 4. Damos valor a '?'
            objPrepared.setString(1, pasajero.getName());
            objPrepared.setString(2, pasajero.getApellido());
            objPrepared.setString(3, pasajero.getDocumentoIdentidad());

            objPrepared.setString(4, pasajero.getId());

            //5. Ejecutamos el query
            int rowAffect = objPrepared.executeUpdate();
            if (rowAffect > 0) {
                System.out.println("Se actualizo correctsmne");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //6. Cerramos la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public void borrarPasajero(String id) {
        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        // Try-catch ya que puede fallar

        try {
            //2. Escribir la sentencia sql
            String sql = "DELETE FROM pasajero WHERE id = ? ;";
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
