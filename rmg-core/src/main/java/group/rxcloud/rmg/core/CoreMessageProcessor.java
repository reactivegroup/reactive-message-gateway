package group.rxcloud.rmg.core;

import group.rxcloud.rmg.processor.MessageProcessor;
import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.publisher.domain.MessagePubResponse;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;
import reactor.core.publisher.Mono;

public abstract class CoreMessageProcessor extends MessageProcessor<MessagePubRequest, MessagePubResponse, MessageSubRequest, MessageSubResponse> {

    @Override
    public Mono<MessageSubRequest> inbound(MessagePubRequest upstreamRequest) {
        return this.convertRequestSync(upstreamRequest);
    }

    @Override
    public Mono<MessagePubResponse> outbound(MessageSubResponse downstreamResponse) {
        return this.convertResponseSync(downstreamResponse);
    }

    protected Mono<MessageSubRequest> convertRequestSync(MessagePubRequest upstreamRequest) {
        return Mono.just(this.convertRequest(upstreamRequest));
    }

    protected Mono<MessagePubResponse> convertResponseSync(MessageSubResponse downstreamResponse) {
        return Mono.just(this.convertResponse(downstreamResponse));
    }

    protected abstract MessageSubRequest convertRequest(MessagePubRequest upstreamRequest);

    protected abstract MessagePubResponse convertResponse(MessageSubResponse downstreamResponse);
}
