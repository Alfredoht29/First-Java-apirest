package com.mycompany.dao;

import com.mycompany.modelo.Galeria;
import com.mycompany.servicios.DBconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    public static void postGaleria(Galeria galeria) {
        DBconnection cnx = new DBconnection();
        cnx.conectar();
        try {
        PreparedStatement statement = cnx.getConexion().prepareStatement("insert into imagecrud(TITLE,DESCRIPTION,URL,IMAGE) VALUES(?,?,?,?);"); 
            statement.setString(1,galeria.getTitulo());
            statement.setString(2,galeria.getDescripcion());
            statement.setString(3,galeria.getDireccion());
            statement.setString(4,galeria.getImagen());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }
    }
}
