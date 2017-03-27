package machine;

import dao.EntityDao;
import machine.domain.Machine;

/**
 * @author luiz
 * @since 26/03/17
 */
public class MachineDao extends EntityDao<Machine> {

    private static MachineDao instance;

    static {
        instance = new MachineDao();
    }

    @Override
    protected Class<Machine> getEntityClass() {
        return Machine.class;
    }

    public static MachineDao getInstance() {
        return instance;
    }
}
