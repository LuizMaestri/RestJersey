package machine;

import machine.domain.Machine;
import response.ResponseFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author luiz
 * @since 27/03/17
 */
@Path("machines")
public class MachineResource {

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<Machine> list(){
        return MachineDao.getInstance().list();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public Machine get(@PathParam("id") Long id){
        return MachineDao.getInstance().get(id);
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response create(Machine machine){
        MachineDao.getInstance().save(machine);
        return ResponseFactory.response200();
    }

    @PUT
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response update(Machine machine){
        MachineDao.getInstance().save(machine);
        return ResponseFactory.response200();
    }

    @DELETE
    @Path("{id}")
    public Response delete(Long id){
        MachineDao.getInstance().delete(id);
        return ResponseFactory.response200();
    }

}
