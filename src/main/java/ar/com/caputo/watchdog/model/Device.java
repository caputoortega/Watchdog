package ar.com.caputo.watchdog.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.caputo.watchdog.model.generic.TimestampedEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@DatabaseTable(tableName = "devices")
public class Device extends TimestampedEntity {

    @NotNull
    @Max(24)
    @Pattern(regexp = "[a-z0-9]+")
    @DatabaseField(id = true, uniqueIndex = true)
    private String id;

    @NotNull
    @DatabaseField
    private User linkedUser;

    @NotNull
    @Max(16)
    @Pattern(regexp = "[A-Za-Z]+")
    @DatabaseField
    private String brand;

    @NotNull
    @Max(32)
    @Pattern(regexp = "[A-Za-z0-9]+")
    @DatabaseField
    private String model;

    @NotNull
    @Max(16)
    @Pattern(regexp = "[A-Za-z]+")
    @DatabaseField
    private String osName;

    @NotNull
    @Max(16)
    @Pattern(regexp = "[A-Za-z0-9]+")
    @DatabaseField
    private String osVersion;

    public Device() {}

    public User getLinkedUser() {
        return linkedUser;
    }

    public void setLinkedUser(User linkedUser) {
        this.linkedUser = linkedUser;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public String id() {
        return this.id;
    }    
    
}
