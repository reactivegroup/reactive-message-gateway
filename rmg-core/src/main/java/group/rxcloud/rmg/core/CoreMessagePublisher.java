package group.rxcloud.rmg.core;

import group.rxcloud.rmg.publisher.MessagePublisher;
import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.publisher.domain.MessagePubResponse;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;
import reactor.core.publisher.Mono;

public abstract class CoreMessagePublisher extends MessagePublisher<MessagePubRequest, MessagePubResponse> {

    private final CoreMessageProcessor messageProcessor;
    private final CoreMessageSubscriber messageSubscriber;

    public CoreMessagePublisher(CoreMessageProcessor messageProcessor, CoreMessageSubscriber messageSubscriber) {
        this.messageProcessor = messageProcessor;
        this.messageSubscriber = messageSubscriber;
    }

    @Override
    public Mono<MessagePubResponse> subscribe(MessagePubRequest request) {
        return Mono.subscriberContext()
                .flatMap(context -> this.offer(request))
                .flatMap(messageSubscriber::onNext)
                .flatMap(this::poll);
    }

    protected Mono<MessageSubRequest> offer(MessagePubRequest request) {
        return doInbound(request);
    }

    protected Mono<MessageSubRequest> doInbound(MessagePubRequest request) {
        return messageProcessor.inbound(request);
    }

    protected Mono<MessagePubResponse> poll(MessageSubResponse response) {
        return doOutbound(response);
    }

    protected Mono<MessagePubResponse> doOutbound(MessageSubResponse response) {
        return messageProcessor.outbound(response);
    }
}
