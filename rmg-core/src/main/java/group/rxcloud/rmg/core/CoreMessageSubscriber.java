package group.rxcloud.rmg.core;

import group.rxcloud.rmg.subscriber.MessageSubscriber;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;
import reactor.core.publisher.Mono;

public abstract class CoreMessageSubscriber<Req extends MessageSubRequest, Res extends MessageSubResponse>
        extends MessageSubscriber<Req, Res> {
}
