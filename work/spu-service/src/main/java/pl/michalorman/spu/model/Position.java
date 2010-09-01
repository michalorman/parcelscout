package pl.michalorman.spu.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@Embeddable
public class Position {

    @XStreamAsAttribute
    @Column(nullable = false)
    private Double latitude;

    @XStreamAsAttribute
    @Column(nullable = false)
    private Double longitude;

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

}
