package group.rxcloud.rmg.core;

import group.rxcloud.rmg.publisher.MessagePublisher;
import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.publisher.domain.MessagePubResponse;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;
import reactor.core.publisher.Mono;

public abstract class CoreMessagePublisher<Req extends MessagePubRequest, Res extends MessagePubResponse>
        extends MessagePublisher<Req, Res> {
}
