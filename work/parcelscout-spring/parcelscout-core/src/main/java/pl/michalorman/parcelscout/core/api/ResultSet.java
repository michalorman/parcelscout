package pl.michalorman.parcelscout.core.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ResultSet")
public class ResultSet {

    public static final String SUCCESS = "1";
    public static final String FAILURE = "2";

    @XStreamAsAttribute
    private String status = SUCCESS;

    @XStreamAlias("Result")
    private Result result;

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
