package com.mycompany.dao;

import com.mycompany.modelo.Galeria;
import com.mycompany.servicios.DBconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emilio
 */
public class GaleriaDao {

    public static List<Galeria> getGaleria()
    {
        DBconnection cnx = new DBconnection();
        cnx.conectar();
        List<Galeria> galerial = new ArrayList();
        try{
        Statement statement = cnx.getConexion().createStatement();
        ResultSet set = statement.executeQuery("select * from galeria.imagecrud");
        while(set.next()){
            Galeria galeria = new Galeria();
            galeria.setId(set.getInt("ID"));
            galeria.setTitulo(set.getString("TITLE"));
            galeria.setDescripcion(set.getString("DESCRIPTION"));
            galeria.setDireccion(set.getString("URL"));
            galeria.setImagen(set.getString("IMAGE"));
            galerial.add(galeria);
        }
        set.close();
        statement.close();
        }catch(SQLException sql){
            System.out.println(sql);
        }
        return galerial;
    }
}