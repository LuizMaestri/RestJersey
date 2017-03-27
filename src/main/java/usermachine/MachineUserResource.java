package usermachine;

import machine.MachineDao;
import machine.domain.Machine;
import response.ResponseFactory;
import user.UserDao;
import user.domain.User;
import usermachine.domain.MachineUser;
import usermachine.dto.MachineUpDto;
import usermachine.dto.MachineUserCreateDto;
import usermachine.dto.MachineUserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author luiz
 * @since 27/03/17
 */
@Path("admin")
public class MachineUserResource {

    @GET
    @Path("machines/{codUser}")
    @Produces(APPLICATION_JSON)
    public MachineUserDto list(@PathParam("codUser") Long codUser){
        User user = UserDao.getInstance().get(codUser);
        Set<MachineUser> machines = user.getMachines();
        return new MachineUserDto(machines, user);
    }

    @PUT
    @Path("machines/changestatus")
    @Consumes(APPLICATION_JSON)
    public Response upMachine(MachineUpDto machineUp){
        Long codUser = machineUp.getCodUser();
        User user = UserDao.getInstance().get(codUser);
        Set<MachineUser> machines = user.getMachines();
        machines.forEach(machineUser -> {
            Long codMachine = machineUp.getCodMachine();
            if (machineUser.getMachine().getId().equals(codMachine)) {
                machineUser.setActive(machineUp.isActive());
            }
        });
        return ResponseFactory.response200();
    }

    @POST
    @Path("machines/{codUser}")
    @Consumes(APPLICATION_JSON)
    public Response create(@PathParam("codUser") Long codUser, MachineUserCreateDto newMachine){
        Long codMachine = newMachine.getCodMachine();
        String nick = newMachine.getNickname();
        User user = UserDao.getInstance().get(codUser);
        Machine machine = MachineDao.getInstance().get(codMachine);
        MachineUser newInstance = new MachineUser();
        newInstance.setUser(user);
        newInstance.setMachine(machine);
        newInstance.setNickname(nick);
        user.getMachines().add(newInstance);
        UserDao.getInstance().save(user);
        return ResponseFactory.response200();
    }
}
