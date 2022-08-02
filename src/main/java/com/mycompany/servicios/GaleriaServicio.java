package com.mycompany.servicios;

import com.mycompany.dao.GaleriaDao;
import com.mycompany.dao.PostDao;
import com.mycompany.modelo.Galeria;
import java.util.List;
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
    public static Galeria galeriasearch;
    private static List<Galeria> galerial = GaleriaDao.getGaleria();

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
        titulo = galeria.getTitulo();
        postDao.postGaleria(galeria);
        return Response.ok(titulo).build();

    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchGaleria(Galeria galeria) {
        Galeria x = new Galeria();
        x.setId(galeria.getId());
        if (galerial.contains(x)) {
            for (Galeria obj : galerial) {
                if (obj.getId() == galeria.getId()) {
                    return Response.ok(obj).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
