package group.rxcloud.rmg.email.core;

import group.rxcloud.rmg.core.CoreMessagePublisher;
import group.rxcloud.rmg.email.core.domain.SendEmailRequest;
import group.rxcloud.rmg.email.core.domain.SendEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SimpleEmailPublisher extends CoreMessagePublisher<SendEmailRequest, SendEmailResponse> {

    @Autowired
    private SimpleSyncEmailProcessor emailProcessor;
    @Autowired
    private EmailSubscriber emailSubscriber;

    @Override
    public Mono<SendEmailResponse> subscribe(SendEmailRequest request) {
        return Mono.subscriberContext()
                .flatMap(context -> emailProcessor.inbound(request))
                .flatMap(sendEmailRequest -> emailSubscriber.onNext(sendEmailRequest))
                .flatMap(sendEmailResponse -> emailProcessor.outbound(sendEmailResponse));
    }
}
