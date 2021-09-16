package group.rxcloud.rmg.email.core.domain;

/**
 * The Email Response Info.
 */
public class EmailResponse {

    /**
     * Distributed unique tracking ID.
     */
    private String tracingId;

    /**
     * Mail sending platform tracking ID.
     */
    private String responseId;

    public String getTracingId() {
        return tracingId;
    }

    public void setTracingId(String tracingId) {
        this.tracingId = tracingId;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }
}
