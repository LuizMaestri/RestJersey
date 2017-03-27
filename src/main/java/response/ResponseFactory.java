package response;

import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.*;

/**
 * @author luiz
 * @since 26/03/17
 */
public class ResponseFactory {

    private static Response createResponse(int status){
        return Response.status(status).build();
    }

    public static Response response200(){
        return ResponseFactory.createResponse(OK.getStatusCode());
    }
}
