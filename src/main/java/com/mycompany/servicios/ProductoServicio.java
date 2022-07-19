package com.mycompany.servicios;

import com.mycompany.dao.GaleriaDao;
import com.mycompany.dao.ProductoDao;
import com.mycompany.modelo.Galeria;
import com.mycompany.modelo.Producto;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Emilio
 */
@Path("productos")
public class ProductoServicio {

    private static List<Producto> lista = ProductoDao.getProductos();
    private static List<Galeria> galerial = GaleriaDao.getGaleria();
    
    
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getProducto(@Suspended
            final AsyncResponse asyncResponse, @PathParam(value = "id")
            final int id) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetProducto(id));
            }
        });
    }

    private Response doGetProducto(@PathParam("id") int id) {
        Producto producto = new Producto();
        producto.setId(id);
        if (lista.contains(producto)) {
            for (Producto obj : lista) {
                if (obj.getId() == id) {
                    return Response.ok(obj).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getProductos(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doGetProductos());
            }
        });
    }

    private Response doGetProductos() {
        return Response.ok(lista).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path(value = "test")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void getGalerias(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            public void run() {
                asyncResponse.resume(doGetGalerias());
            }
        });
    }

    private Response doGetGalerias() {
        return Response.ok(galerial).header("Access-Control-Allow-Origin", "*").build();
    }

}
