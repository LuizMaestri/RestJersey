package usermachine.domain;

import machine.domain.Machine;
import user.domain.User;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author luiz
 * @since 27/03/17
 */
@Embeddable
class MachineUserId implements Serializable {
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private Machine machine;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
