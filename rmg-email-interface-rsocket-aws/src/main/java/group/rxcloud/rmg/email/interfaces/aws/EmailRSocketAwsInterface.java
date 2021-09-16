package group.rxcloud.rmg.email.interfaces.aws;

import group.rxcloud.rmg.core.CoreMessagePublisher;
import group.rxcloud.rmg.email.core.domain.SendEmailRequest;
import group.rxcloud.rmg.email.core.domain.SendEmailResponse;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class EmailRSocketAwsInterface {

    @Autowired
    private CoreMessagePublisher<SendEmailRequest, SendEmailResponse> emailPublisher;

    @MessageMapping("checkHealth")
    public String checkHealth() {
        return "ok";
    }

    @MessageMapping("sendEmail")
    public Mono<SendEmailResponse> sendEmail(SendEmailRequest sendEmailRequest) {
        return emailPublisher.subscribe(sendEmailRequest);
    }

    @MessageMapping("sendEmailWithNonResponse")
    public void sendEmailWithNonResponse(SendEmailRequest sendEmailRequest) {
        emailPublisher.subscribe(sendEmailRequest)
                .subscribe(System.out::println);
    }

    @MessageMapping("sendEmailStream")
    public Flux<SendEmailResponse> stream(List<SendEmailRequest> sendEmailRequests) {
        Stream<Mono<SendEmailResponse>> monoStream = sendEmailRequests.stream()
                .map(sendEmailRequest -> emailPublisher.subscribe(sendEmailRequest));
        return Flux.fromStream(monoStream)
                .flatMap(sendEmailResponseMono -> sendEmailResponseMono);
    }

    @MessageMapping("sendEmailWithRateLimit")
    public Mono<Void> sendEmailWithRateLimit(Flux<SendEmailRequest> sendEmailRequests) {
        // create a single Message and return it
        sendEmailRequests.subscribe(new Subscriber<SendEmailRequest>() {

            private Subscription s;
            int onNextAmount;

            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                s.request(2);
            }

            @Override
            public void onNext(SendEmailRequest integer) {
                System.out.println(integer);
                onNextAmount++;
                if (onNextAmount % 2 == 0) {
                    s.request(2);
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onComplete() {
            }
        });
        return Mono.empty();
    }
}
