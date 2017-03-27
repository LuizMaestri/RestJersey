package usermachine.dto;

import java.io.Serializable;

/**
 * @author luiz
 * @since 27/03/17
 */
public class MachineUpDto implements Serializable{

    private Long codUser;
    private Long codMachine;
    private boolean active;

    public Long getCodUser() {
        return codUser;
    }

    public void setCodUser(Long codUser) {
        this.codUser = codUser;
    }

    public Long getCodMachine() {
        return codMachine;
    }

    public void setCodMachine(Long codMachine) {
        this.codMachine = codMachine;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
