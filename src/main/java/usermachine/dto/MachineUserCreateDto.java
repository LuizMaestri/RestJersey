package usermachine.dto;

import java.io.Serializable;

/**
 * @author luiz.maestri
 * @since 27/03/17
 */
public class MachineUserCreateDto implements Serializable{
    private Long codMachine;
    private String nickname;

    public Long getCodMachine() {
        return codMachine;
    }

    public void setCodMachine(Long codMachine) {
        this.codMachine = codMachine;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
