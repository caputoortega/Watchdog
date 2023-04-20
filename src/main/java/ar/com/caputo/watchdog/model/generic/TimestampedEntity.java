package ar.com.caputo.watchdog.model.generic;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    /**
     * This will preserve the original value during
     * object retrieval but generate a new one during
     * object creation.
     * @param timestamp
     */
    public void setCreationDate(Timestamp timestamp) {
        this.creationDate = timestamp == null ?
                            Timestamp.valueOf(LocalDateTime.now()) 
                            : timestamp;
    }

}
