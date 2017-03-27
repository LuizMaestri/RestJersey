package dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * @author luiz
 * @since 26/03/17
 */
@MappedSuperclass
public class EntityMap implements Serializable{

    @Column(name = "dta_time_create", nullable = false, updatable = false)
    @Temporal(TIMESTAMP)
    private Date timeCreation;

    protected Date getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(Date timeCreation) {
        this.timeCreation = timeCreation;
    }
}
