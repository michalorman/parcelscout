package pl.michalorman.parcelscout.integration.spu.model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Package {

    @XStreamAsAttribute
    private Integer id;

    private Position position;

    public Integer getId() {
        return id;
    }

    public double getLatitude() {
        return position.getLatitude();
    }

    public double getLongitude() {
        return position.getLongitude();
    }
}
