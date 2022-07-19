

package com.mycompany.modelo;

/**
 *
 * @author Emilio
 */
public class Galeria {
    private int id;
    private String titulo;
    private String descripcion;
    private String direccion;
    private String imagen;
    
    public Galeria() {
    }
    public Galeria(int id,String titulo,String descripcion,String direccion,String imagen){
       this.id=id;
       this.titulo=titulo;
       this.descripcion=descripcion;
       this.direccion=direccion;
       this.imagen=imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}

