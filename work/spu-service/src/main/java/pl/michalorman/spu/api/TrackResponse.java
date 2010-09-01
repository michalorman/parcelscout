package pl.michalorman.spu.api;

import pl.michalorman.spu.model.Package;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("response")
public class TrackResponse {

    public interface Status {
        Integer SUCCESS = 101;
        Integer FAILURE = 201;
    }

    @XStreamAsAttribute
    private Integer status = Status.SUCCESS;

    @XStreamAlias("package")
    private Package parcel;

    private TrackResponse(Integer status, Package parcel) {
        this.status = status;
        this.parcel = parcel;
    }

    public static TrackResponse successResponse(Package parcel) {
        return new TrackResponse(Status.SUCCESS, parcel);
    }

    public static TrackResponse failureResponse() {
        return new TrackResponse(Status.FAILURE, null);
    }

    public Integer getStatus() {
        return status;
    }

    public Package getPackage() {
        return parcel;
    }

}
