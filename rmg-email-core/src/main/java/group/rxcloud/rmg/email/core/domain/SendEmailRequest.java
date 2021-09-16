package group.rxcloud.rmg.email.core.domain;


import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;

/**
 * The Send Email Request.
 */
public class SendEmailRequest implements MessageSubRequest, MessagePubRequest {

    /**
     * Email request info.
     */
    private EmailRequest emailRequest;

    /**
     * Email detail info.
     */
    private EmailDetail emailDetail;

    public EmailRequest getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(EmailRequest emailRequest) {
        this.emailRequest = emailRequest;
    }

    public EmailDetail getEmailDetail() {
        return emailDetail;
    }

    public void setEmailDetail(EmailDetail emailDetail) {
        this.emailDetail = emailDetail;
    }
}
