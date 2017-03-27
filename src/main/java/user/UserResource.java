package user;

import response.ResponseFactory;
import user.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author luiz
 * @since 26/03/17
 */
@Path("users")
public class UserResource {

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public List<User> list(){
        return UserDao.getInstance().list();
    }

    @GET
    @Path("{id}")
    @Produces(APPLICATION_JSON)
    public User get(@PathParam("id") Long id){
        return UserDao.getInstance().get(id);
    }

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response create(User user){
        UserDao.getInstance().save(user);
        return ResponseFactory.response200();
    }

    @PUT
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response update(User user){
        UserDao.getInstance().save(user);
        return ResponseFactory.response200();
    }

    @DELETE
    @Path("{id}")
    public Response delete(Long id){
        UserDao.getInstance().delete(id);
        return ResponseFactory.response200();
    }

}
