package user;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * @author luiz
 * @since 26/03/17
 */
@Path("user")
public class UserResource {

    @GET
    @Produces(TEXT_PLAIN)
    public String getMessage(@QueryParam("msg") String msg){
        return "You message is: " + msg;
    }

    @GET
    @Produces(TEXT_PLAIN)
    @Path("{id}")
    public String getUser(@PathParam("id") Long id){
        return "You user is number: " + id;
    }

}
