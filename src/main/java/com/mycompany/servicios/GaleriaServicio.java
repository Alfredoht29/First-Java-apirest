package com.mycompany.servicios;

import com.mycompany.dao.PostDao;
import com.mycompany.modelo.Galeria;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Emilio
 */
@Path("galeria")
public class GaleriaServicio {

    private PostDao postDao;
    public static  Galeria galeriasearch;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGetResp() {
        return Response.ok(galeriasearch).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGaleria(Galeria galeria) {
        String titulo;
        titulo=galeria.getTitulo();
        postDao.postGaleria(galeria);
        return Response.ok(titulo).build();

    }
    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchGaleria(Galeria galeria) {
        galeriasearch=galeria;
        return Response.ok(galeriasearch).build();

    }

}
