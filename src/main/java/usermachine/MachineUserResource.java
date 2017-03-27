package usermachine;

import machine.domain.Machine;
import response.ResponseFactory;
import user.UserDao;
import user.domain.User;
import usermachine.domain.MachineUser;
import usermachine.dto.MachineUpDto;
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
    @Consumes
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
}
