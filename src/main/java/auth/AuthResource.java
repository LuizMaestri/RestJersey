package auth;

import auth.dto.LoginDto;
import response.ResponseFactory;
import user.UserDao;
import user.domain.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author luiz.maestri
 * @since 27/03/17
 */
@Path("auth")
public class AuthResource {

    @POST
    @Path("login")
    @Consumes(APPLICATION_JSON)
    public Response loginUser(LoginDto login){
        String username = login.getLogin();
        String password = login.getPassword();
        if (username != null && password != null){
            User user = this.loginByUser(username, password);
        }
        return ResponseFactory.response200();
    }

    private User loginByUser(String username, String password) {
        return UserDao.getInstance().authenticate(username, password);
    }

}
