package user;

import dao.EntityDao;
import user.domain.User;

/**
 * @author luiz
 * @since 26/03/17
 */
public class UserDao extends EntityDao<User> {

    private static UserDao instance;
    static {
        instance = new UserDao();
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    public static UserDao getInstance() {
        return instance;
    }
}
