package pl.michalorman.parcelscout.integration.spu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Package {

    @XmlAttribute
//    @JsonProperty("id")
    private Integer id;

    @XmlElement
//    @JsonProperty("position")
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
