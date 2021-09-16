package group.rxcloud.rmg.email.core.domain;


import group.rxcloud.rmg.publisher.domain.MessagePubResponse;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;

/**
 * The Send Email Response.
 */
public class SendEmailResponse implements MessageSubResponse, MessagePubResponse {

    /**
     * The response code.
     */
    private String code;

    /**
     * The response message.
     */
    private String message;

    /**
     * The response info.
     */
    private EmailResponse emailResponse;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmailResponse getEmailResponse() {
        return emailResponse;
    }

    public void setEmailResponse(EmailResponse emailResponse) {
        this.emailResponse = emailResponse;
    }
}
