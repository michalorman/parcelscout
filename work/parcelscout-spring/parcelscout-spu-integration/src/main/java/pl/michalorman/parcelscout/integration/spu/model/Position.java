package pl.michalorman.parcelscout.integration.spu.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Position {

    @XmlAttribute
    private double latitude;

    @XmlAttribute
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
