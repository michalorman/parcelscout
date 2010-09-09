package pl.michalorman.parcelscout.core.api;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ResultSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultSet {

    public static final String SUCCESS = "1";
    public static final String FAILURE = "2";

    @XmlAttribute
    private String status = SUCCESS;

    @XmlElement(name = "Result")
    private Result result;

    public ResultSet() {
    }

    private ResultSet(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public Result getResult() {
        return result;
    }

    public static ResultSet createSuccessfulResultSet(Result result) {
        return new ResultSet(result);
    }

    public static ResultSet createFailureResultSet() {
        ResultSet set = new ResultSet(null);
        set.status = FAILURE;
        return set;
    }

    public static ResultSet createSuccessfulResultSet(Integer packageId, double latitude, double longitude) {
        return createSuccessfulResultSet(new Result(packageId, latitude, longitude));
    }
}
