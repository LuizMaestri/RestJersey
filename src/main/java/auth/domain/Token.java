package auth.domain;

import dao.EntityMap;
import user.domain.User;

import javax.persistence.*;

/**
 * @author luiz.maestri
 * @since 27/03/17
 */
@Entity
@Table(name = "token")
public class Token extends EntityMap{

    public static final Integer validate = 1;

    @Id
    @Column(name = "dsc_token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "cod_user")
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
