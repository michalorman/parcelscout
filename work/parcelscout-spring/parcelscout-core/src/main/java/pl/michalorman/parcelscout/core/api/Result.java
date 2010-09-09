package pl.michalorman.parcelscout.core.api;

import javax.xml.bind.annotation.XmlElement;

public class Result {

    @XmlElement(name = "PackageID")
    private Integer packageId;

    @XmlElement(name = "Latitude")
    private double latitude;

    @XmlElement(name = "Longitude")
    private double longitude;

    public Result() {
    }

    public Result(Integer packageId, double latitude, double longitude) {
        this.packageId = packageId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
