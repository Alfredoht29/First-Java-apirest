package com.mycompany.servicios;
import com.mycompany.dao.GaleriaDao;
import java.sql.SQLException;

/**
 *
 * @author Emilio
 */
public class Main {
    public static void main(String[] args) throws SQLException {
     GaleriaDao test = new GaleriaDao();
     test.getGaleria();
    }
}
