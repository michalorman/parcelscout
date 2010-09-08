package pl.michalorman.parcelscout.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Result {

    @XStreamAlias("PackageID")
    private String packageId;

    @XStreamAlias("Latitude")
    private String latitude;

    @XStreamAlias("Longitude")
    private String longitude;

    public Result(String packageId, String latitude, String longitude) {
        this.packageId = packageId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
