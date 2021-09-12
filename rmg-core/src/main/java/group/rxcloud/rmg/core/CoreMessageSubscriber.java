package group.rxcloud.rmg.core;

import group.rxcloud.rmg.subscriber.MessageSubscriber;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;
import reactor.core.publisher.Mono;

public abstract class CoreMessageSubscriber extends MessageSubscriber<MessageSubRequest, MessageSubResponse> {

    @Override
    public Mono<MessageSubResponse> onNext(MessageSubRequest request) {
        return this.doOnNext(request);
    }

    protected abstract Mono<MessageSubResponse> doOnNext(MessageSubRequest request);
}
