package pl.michalorman.parcelscout.integration.spu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;

public class Position {

    @XmlAttribute
//    @JsonProperty("latitude")
    private double latitude;

    @XmlAttribute
//    @JsonProperty("longitude")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
