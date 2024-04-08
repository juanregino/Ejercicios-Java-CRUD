package model;

import database.ConfigDB;
import entity.Avion;
import entity.Vuelo;
import repository.VueloCRUDRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VueloModel implements VueloCRUDRepository {
    @Override
    public void agregarVuelo(Vuelo vuelo) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        //try-catch ya que puede fallar
        try {
            //2. Sentencia SQL
            String sql = "INSERT INTO vuelo (id,destino,fechaSalida,horaSalida,idAvion) VALUES(?,?,?,?,?)";
            //3. Preparar e statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //Asignar los '?'
            objPrepared.setString(1, vuelo.getId());
            objPrepared.setString(2, vuelo.getDestino());
            objPrepared.setDate(3, vuelo.getFechaSalida());
            objPrepared.setTime(4, vuelo.getHoraSalida());
            objPrepared.setString(5, vuelo.getIdAvion());

            //4. Ejecutamos el query o 'consulta'
            objPrepared.execute();

            System.out.println("Vuelo insertado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Cerrar la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public Vuelo buscarPorId(String id) {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();

        Vuelo objVuelo = new Vuelo();
        Avion objAvion = new Avion();
        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM vuelo  INNER JOIN avion ON vuelo.idAvion = avion.id WHERE vuelo.id = ? ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);
            //5. Damos valor al '?'
            objPrepared.setString(1, id);
            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();

            while (objResult.next()){

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
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objVuelo;

    }

    @Override
    public List<Vuelo> listarVuelos() {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();

        Vuelo objVuelo = new Vuelo();
        Avion objAvion = new Avion();
        List<Vuelo> listVuelos = new ArrayList<>();

        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM vuelo  INNER JOIN avion ON vuelo.idAvion = avion.id ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
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

                listVuelos.add(objVuelo);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVuelos ;

    }

    @Override
    public void actualizarVuelo(Vuelo vuelo) {
        //1. Abro la conexion
        Connection objConnection = ConfigDB.openConnection();
        //Try-catch ya que puede fallar
        try {
            //2. Sentencia sql
            String sql = "UPDATE vuelo SET destino = ? , fechaSalida = ? , horaSalida = ?, idAvion = ?  WHERE vuelo.id = ? ;";
            //3. Preparar el estado
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            // 4. Damos valor a '?'
            objPrepared.setString(1, vuelo.getDestino());
            objPrepared.setDate(2, vuelo.getFechaSalida());
            objPrepared.setTime(3, vuelo.getHoraSalida());
            objPrepared.setString(4, vuelo.getIdAvion());
            objPrepared.setString(5, vuelo.getId());

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
    public void borrarVuelo(String id) {
//1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        // Try-catch ya que puede fallar

        try {
            //2. Escribir la sentencia sql
            String sql = "DELETE FROM vuelo WHERE id = ? ;";
            //3. Preparamos el statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //4. Asignamos el valor al ?
            objPrepared.setString(1,id);

            //5. Ejecutamos el query
            objPrepared.execute();

            System.out.println("Eliminado exitosamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        //6. Cerramos la conexión
        ConfigDB.closeConnection();
    }
}
