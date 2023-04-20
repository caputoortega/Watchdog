package ar.com.caputo.watchdog.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.caputo.watchdog.model.generic.Entity;
import jakarta.validation.constraints.NotNull;

@DatabaseTable(tableName = "watches")
public class Watch extends Entity {

    enum State {
        ON_DUTY,
        OFF_DUTY
    }

    @DatabaseField(generatedId = true)
    private Long id;

    @NotNull
    @DatabaseField(foreign = true)
    private Staff leader;

    @NotNull
    @DatabaseField
    private State state;

    @ForeignCollectionField(foreignFieldName = "assignedWatch", eager = false, maxEagerLevel = 1)
    private ForeignCollection<Staff> staff;

    public Watch() {}

    public Staff getLeader() {
        return leader;
    }

    public void setLeader(Staff leader) {
        this.leader = leader;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ForeignCollection<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ForeignCollection<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public Long id() {
        return this.id;
    }

    
    
}
