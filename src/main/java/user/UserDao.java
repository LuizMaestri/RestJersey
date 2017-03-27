package user;

import dao.EntityDao;
import org.hibernate.query.Query;
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

    public User authenticate(String username, String password) {
        this.openTransaction();
        Query query = session.createNativeQuery("select u from user u where u.nme_user=:username and u.nme_password=HASH('SHA256', STRINGTOUTF8(:password), 1000)");
        query = query.setParameter("username", username);
        query = query.setParameter("password", password);
        User user = (User) query.getSingleResult();
        this.closeTransaction();
        return user;
    }
}
