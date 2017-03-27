package machine.domain;

import dao.EntityMap;
import usermachine.domain.MachineUser;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

/**
 * @author luiz
 * @since 26/03/17
 */
@Entity
@Table(name = "machine")
public class Machine extends EntityMap {

    @Id
    @Column(name = "cod_entity")
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(name = "nme_machine", unique = true, nullable = false)
    @Enumerated(STRING)
    private  Type machine;
    @Column(name = "vl_memory", nullable = false)
    private Long memory;
    @Column(name = "vl_hard_disc" , nullable = false)
    private Long hardDisc;
    @OneToMany(fetch = LAZY, mappedBy = "id.machine", cascade = ALL)
    private Set<MachineUser> users;

    protected Machine(){
        this.setUsers(new HashSet<>());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getMachine() {
        return machine;
    }

    public void setMachine(Type machine) {
        this.machine = machine;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getHardDisc() {
        return hardDisc;
    }

    public void setHardDisc(Long hardDisc) {
        this.hardDisc = hardDisc;
    }

    public Set<MachineUser> getUsers() {
        return users;
    }

    public void setUsers(Set<MachineUser> users) {
        this.users = users;
    }
}
