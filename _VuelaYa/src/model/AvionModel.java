package model;

import database.ConfigDB;
import entity.Avion;
import repository.AvionCRUDRespository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvionModel implements AvionCRUDRespository {

    @Override
    public void agregarAvion(Avion avion) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();
        //try-catch ya que puede fallar
        try {
            //2. Sentencia SQL
            String sql = "INSERT INTO avion (id,modelo,capacidad) VALUES(?,?,?)";
            //3. Preparar e statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //Asignar los '?'
            objPrepared.setString(1, avion.getId());
            objPrepared.setString(2, avion.getModelo());
            objPrepared.setInt(3, avion.getCapacidad());


            //4. Ejecutamos el query o 'consulta'
            objPrepared.execute();

            System.out.println("El avion fue agregado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Cerrar la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public Avion buscarPorId(String id) {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();
        //Instancio un avion en null para o vacío para llenarlo con la respuesta
        Avion objAvion = new Avion();
        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "SELECT * FROM avion WHERE id =  ?; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);
            //5. Damos valor al '?'
            objPrepared.setString(1, id);
            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                objAvion.setId(objResult.getString("id"));
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAvion;
    }

    @Override
    public List<Avion> listarAviones() {
        //1. Abrimos la conexion
        Connection objconnection = ConfigDB.openConnection();
        //Instancio un avion en null para o vacío para llenarlo con la respuesta
        List<Avion> lisProducts = new ArrayList<>();
        //try-catch ya que algo puede fallar
        try {
            //3. Creo la sentencia SQL
            String sql = "select * from avion ; ";
            //4. Preparo el statement
            PreparedStatement objPrepared = objconnection.prepareStatement(sql);

            //6. Ejecutamos el query
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()) {
                Avion objAvion = new Avion();
                objAvion.setId(objResult.getString("id"));
                objAvion.setModelo(objResult.getString("modelo"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));

                lisProducts.add(objAvion);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return lisProducts;

    }

    @Override
    public void actualizarAvion(Avion avion) {
        //1. Abro la conexion
        Connection objConnection = ConfigDB.openConnection();
        //Try-catch ya que puede fallar
        try {
            //2. Sentencia sql
            String sql = "UPDATE avion SET modelo = ? , capacidad = ? WHERE id = ? ;";
            //3. Preparar el estado
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            // 4. Damos valor a '?'
            objPrepared.setString(1, avion.getModelo());
            objPrepared.setInt(2, avion.getCapacidad());
            objPrepared.setString(3, avion.getId());


            //5. Ejecutamos el query
            int rowAffect = objPrepared.executeUpdate();
            if (rowAffect > 0) {
                System.out.println("Se actualizo correctamente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //6. Cerramos la conexion
        ConfigDB.closeConnection();
    }

    @Override
    public void borrarAvion(String id) {
//1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();
        // Try-catch ya que puede fallar

        try {
            //2. Escribir la sentencia sql
            String sql = "DELETE FROM avion WHERE id = ? ;";
            //3. Preparamos el statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //4. Asignamos el valor al ?
            objPrepared.setString(1, id);

            //5. Ejecutamos el query
            objPrepared.execute();

            System.out.println("Eliminado con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //6. Cerramos la conexión
        ConfigDB.closeConnection();
    }
}
