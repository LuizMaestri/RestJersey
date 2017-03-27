package user.domain;

import auth.domain.Token;
import dao.EntityMap;
import org.hibernate.annotations.ColumnTransformer;
import usermachine.domain.MachineUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

/**
 * @author luiz
 * @since 26/03/17
 */
@Entity
@Table(name = "user", schema = "PUBLIC")
public class User extends EntityMap{

    @Id
    @Column(name = "cod_entity")
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(name = "nme_user", nullable = false, unique = true, length = 20)
    private String username;
    @Column(name = "nme_password", nullable = false, length = 64)
    @ColumnTransformer(forColumn = "nme_password", write = "HASH('SHA256', STRINGTOUTF8(?), 1000)")
    private String password;
    @Enumerated
    @Column(name = "dsc_role")
    private Role role;
    @Enumerated
    @Column(name = "dsc_status")
    private Status status;
    @OneToMany(fetch = LAZY, mappedBy = "id.user", cascade = ALL)
    private Set<MachineUser> machines;
    @OneToMany(fetch = LAZY, mappedBy = "user", cascade = ALL)
    private Set<Token> tokens;

    protected User(){
        this.setMachines(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<MachineUser> getMachines() {
        return this.machines;
    }

    public void setMachines(Set<MachineUser> machines) {
        this.machines = machines;
    }

    public Set<Token> getTokens() {
        return this.tokens;
    }

    public void setTokens(Set<Token> tokens) {
        this.tokens = tokens;
    }
}
