package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection connection;

    public static  Connection openConnection (){
        //Try catch , ya que puede fallar
        try{
            //ClassForname permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales
            String url = "jdbc:mysql://uuquawvgdybupzln:pAwyAjCl7wRq9AEUbPbc@bths6vixfoj0e8dpty25-mysql.services.clever-cloud.com:3306/bths6vixfoj0e8dpty25";
            String userName = "uuquawvgdybupzln";
            String password = "pAwyAjCl7wRq9AEUbPbc";

            // establecemos la conexión
            connection = (Connection) DriverManager.getConnection(url,userName,password);
            System.out.println("Conexion Correcta");
        }catch (ClassNotFoundException e){
            System.out.println("Error >> Driver no instalado");
            System.out.println(e.getMessage());
        }catch (SQLException e){
            System.out.println("Error >> No se pudo establecer la conexión");
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void closeConnection(){
        //Try-catch ya que puede fallar
        try {
            //Si hay una conexion activa la cerramos
            if(connection != null ) connection.close();

        }catch (SQLException e){
            System.out.println("No se pudo cerrar la conexión");
        }
    }
}
