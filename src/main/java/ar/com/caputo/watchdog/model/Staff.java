package ar.com.caputo.watchdog.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.caputo.watchdog.model.generic.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@DatabaseTable(tableName = "staff")
public class Staff extends Entity {
    
    @NotNull
    @NotBlank
    @Max(16)
    @Pattern(regexp = "[A-Za-z0-9]+")
    @DatabaseField(id = true, uniqueIndex = true)
    private String id;

    @NotNull
    @NotBlank
    @Max(32)
    @Pattern(regexp = "[A-Za-z]+")
    @DatabaseField
    private String firstName;

    @NotNull
    @NotBlank
    @Max(32)
    @Pattern(regexp = "[A-Za-z]+")
    @DatabaseField
    private String lastName;

    @NotNull
    @DatabaseField(foreign = true)
    private Watch assignedWatch;

    public Staff() {}

    @Override
    public String id() {
        return this.id;
    }

}
