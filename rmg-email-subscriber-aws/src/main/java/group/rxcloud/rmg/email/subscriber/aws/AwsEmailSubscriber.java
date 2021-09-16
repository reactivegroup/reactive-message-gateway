package group.rxcloud.rmg.email.subscriber.aws;

import group.rxcloud.rmg.email.core.EmailSubscriber;
import group.rxcloud.rmg.email.core.domain.SendEmailRequest;
import group.rxcloud.rmg.email.core.domain.SendEmailResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AwsEmailSubscriber extends EmailSubscriber {

    @Override
    public Mono<SendEmailResponse> onNext(SendEmailRequest request) {
        return Mono.just(new SendEmailResponse());
    }
}
