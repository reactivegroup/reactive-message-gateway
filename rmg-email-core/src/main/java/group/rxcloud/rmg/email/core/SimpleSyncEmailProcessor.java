package group.rxcloud.rmg.email.core;

import group.rxcloud.rmg.core.CoreMessageProcessor;
import group.rxcloud.rmg.email.core.domain.SendEmailRequest;
import group.rxcloud.rmg.email.core.domain.SendEmailResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SimpleSyncEmailProcessor extends CoreMessageProcessor<SendEmailRequest, SendEmailResponse, SendEmailRequest, SendEmailResponse> {

    @Override
    public Mono<SendEmailRequest> inbound(SendEmailRequest upstreamRequest) {
        return Mono.just(upstreamRequest);
    }

    @Override
    public Mono<SendEmailResponse> outbound(SendEmailResponse downstreamResponse) {
        return Mono.just(downstreamResponse);
    }
}
