package usermachine.dto;

import machine.domain.Machine;
import user.domain.User;
import usermachine.domain.MachineUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author luiz
 * @since 27/03/17
 */
public class MachineUserDto implements Serializable {
    private User user;
    private List<Machine> machines;

    public MachineUserDto(Set<MachineUser> machines, User user) {
        this.user = user;
        this.machines = new ArrayList<>();
        machines.forEach( machine -> this.machines.add(machine.getMachine()));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }
}
