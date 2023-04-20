package ar.com.caputo.watchdog.model;

import java.util.UUID;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.caputo.watchdog.model.generic.TimestampedEntity;
import ar.com.caputo.watchdog.type.Location;
import jakarta.validation.constraints.NotNull;

@DatabaseTable(tableName = "alerts")
public class Alert extends TimestampedEntity {
    
    enum State {
        ACTIVE,
        FINISHED,
        FALSE_ALARM,
        CANCELLED

    }

    @NotNull
    @DatabaseField(generatedId = true, dataType = DataType.UUID_NATIVE)
    public UUID id;

    @DatabaseField(dataType = DataType.SERIALIZABLE)
    public Location location;

    public Alert() {}

    @Override
    public UUID id() {
        return this.id;
    }


    

}
