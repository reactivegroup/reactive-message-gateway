package group.rxcloud.rmg.email.core;

import group.rxcloud.rmg.core.CoreMessageSubscriber;
import group.rxcloud.rmg.email.core.domain.SendEmailRequest;
import group.rxcloud.rmg.email.core.domain.SendEmailResponse;

public abstract class EmailSubscriber extends CoreMessageSubscriber<SendEmailRequest, SendEmailResponse> {
}
