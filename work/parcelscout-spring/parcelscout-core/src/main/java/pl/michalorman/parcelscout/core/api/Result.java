package pl.michalorman.parcelscout.core.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Result {

    @XStreamAlias("PackageID")
    private Integer packageId;

    @XStreamAlias("Latitude")
    private double latitude;

    @XStreamAlias("Longitude")
    private double longitude;

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
