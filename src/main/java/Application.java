import user.UserResource;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

/**
 * @author luiz
 * @since 26/03/17
 */
@ApplicationPath("api")
public class Application extends javax.ws.rs.core.Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(UserResource.class);
        return classes;
    }
}
