package ar.com.caputo.watchdog.model.generic;

import java.sql.Timestamp;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import jakarta.validation.constraints.NotNull;

public abstract class TimestampedEntity extends Entity {

    @NotNull
    @DatabaseField(dataType = DataType.TIME_STAMP, useGetSet = true)
    protected Timestamp creationDate;

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

}
