package pl.michalorman.parcelscout.integration.spu.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("response")
public class Response {

    @XStreamAsAttribute
    private String status;

    @XStreamAlias("package")
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
