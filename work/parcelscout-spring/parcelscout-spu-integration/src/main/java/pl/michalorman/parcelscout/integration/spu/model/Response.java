package pl.michalorman.parcelscout.integration.spu.model;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlAttribute
//    Using the jackson-xc the object may be unmarshalled using JAXB annotations, thus there is no need
//    to have Jackson specific annotations.
//    @JsonProperty("status")
    private String status;

    @XmlElement(name = "package")
//    @JsonProperty("package")
    private Package parcel;

    public boolean isSuccessful() {
        return "101".equals(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPackageId() {
        return parcel.getId();
    }

    public double getPackageLatitude() {
        return parcel.getLatitude();
    }

    public double getPackageLongitude() {
        return parcel.getLongitude();
    }
}
