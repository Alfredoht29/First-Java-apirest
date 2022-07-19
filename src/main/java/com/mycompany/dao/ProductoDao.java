package com.mycompany.dao;
import com.mycompany.modelo.Producto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Emili
 */

public class ProductoDao {
    public static List<Producto> getProductos(){
       List<Producto> lista= new ArrayList(); 
       Producto producto=new Producto(1,"harina",500);
       Producto producto2=new Producto(2,"azucar",600);
       Producto producto3=new Producto(3,"leche",50);
       lista.add(producto);
       lista.add(producto2);
       lista.add(producto3);
       return lista;
    }
}
