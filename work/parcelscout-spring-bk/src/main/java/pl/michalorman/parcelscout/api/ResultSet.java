package pl.michalorman.parcelscout.api;

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

    public static ResultSet createSuccessfulResultSet(Result result) {
        return new ResultSet(result);
    }

    public static ResultSet createFailureResultSet() {
        ResultSet set = new ResultSet(null);
        set.status = FAILURE;
        return set;
    }
}
