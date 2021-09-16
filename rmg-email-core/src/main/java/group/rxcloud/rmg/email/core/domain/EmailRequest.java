package group.rxcloud.rmg.email.core.domain;

import java.util.Map;

/**
 * The Email Request Info.
 */
public class EmailRequest {

    /**
     * Distributed unique tracking ID.
     */
    private String tracingId;

    /**
     * Email Sender alias
     */
    private String emailAlias;

    /**
     * Email Sender from
     */
    private String emailFrom;

    /**
     * Mail channel ID.
     */
    private String channelId;

    /**
     * Mail channel options map.
     */
    private Map<String, String> channelOptions;

    public String getTracingId() {
        return tracingId;
    }

    public void setTracingId(String tracingId) {
        this.tracingId = tracingId;
    }

    public String getEmailAlias() {
        return emailAlias;
    }

    public void setEmailAlias(String emailAlias) {
        this.emailAlias = emailAlias;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Map<String, String> getChannelOptions() {
        return channelOptions;
    }

    public void setChannelOptions(Map<String, String> channelOptions) {
        this.channelOptions = channelOptions;
    }
}
