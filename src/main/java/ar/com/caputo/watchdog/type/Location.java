package ar.com.caputo.watchdog.type;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable {

    private final Double latitude;
    private final Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(latitude, location.latitude) &&
                Objects.equals(longitude, location.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return latitude.toString().concat(",").concat(longitude.toString());
    }
    
}
