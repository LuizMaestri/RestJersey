package usermachine.domain;

import dao.EntityMap;
import machine.domain.Machine;
import user.domain.User;

import javax.persistence.*;

/**
 * @author luiz
 * @since 27/03/17
 */
@Entity
@Table(name = "machine_user")
@AssociationOverrides({
        @AssociationOverride(name = "id.user", joinColumns = @JoinColumn(name = "cod_user")),
        @AssociationOverride(name = "id.machine", joinColumns = @JoinColumn(name = "cod_machine"))
})
public class MachineUser extends EntityMap{

    @EmbeddedId
    private MachineUserId id;
    @Column(name = "nme_nickname")
    private String nickname;
    @Column(name = "fl_active")
    private boolean active;

    public MachineUser(){
        this.setId(new MachineUserId());
    }

    private MachineUserId getId() {
        return this.id;
    }

    private void setId(MachineUserId id) {
        this.id = id;
    }

    @Transient
    public User getUser(){
        return this.getId().getUser();
    }

    public void setUser(User user){
        this.id.setUser(user);
    }

    @Transient
    public Machine getMachine(){
        return this.getId().getMachine();
    }

    public void setMachine(Machine machine){
        this.id.setMachine(machine);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
