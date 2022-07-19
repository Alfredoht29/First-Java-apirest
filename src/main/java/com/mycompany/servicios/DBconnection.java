package com.mycompany.servicios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Emilio
 */
public class DBconnection {

    Connection conexion;

    public void conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/galeria", "root", "S1stemas21");
            System.out.println("Esta dentro");
        } catch (SQLException sql) {
            System.out.println("No entro");
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    

}
