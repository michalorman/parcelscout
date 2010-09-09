package pl.michalorman.parcelscout.integration.spu.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Package {

    @XmlAttribute
    private Integer id;

    @XmlElement
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
