package pl.michalorman.parcelscout.integration.spu.model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Position {

    @XStreamAsAttribute
    private double latitude;

    @XStreamAsAttribute
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
