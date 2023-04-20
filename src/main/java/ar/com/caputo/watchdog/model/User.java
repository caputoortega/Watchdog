package ar.com.caputo.watchdog.model;

import java.util.UUID;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.caputo.watchdog.model.generic.TimestampedEntity;
import jakarta.validation.constraints.NotNull;

@DatabaseTable(tableName = "users")
public class User extends TimestampedEntity {


    @NotNull
    @DatabaseField(generatedId = true, dataType = DataType.UUID_NATIVE)
    private UUID id;

    @DatabaseField(foreign = true, canBeNull = true)
    private Staff associatedStaff;

    @ForeignCollectionField(foreignFieldName = "linkedUser")
    private ForeignCollection<Device> linkedDevices;

    public User() {}

    @Override
    public UUID id() {
        return this.id;
    }

    

}
