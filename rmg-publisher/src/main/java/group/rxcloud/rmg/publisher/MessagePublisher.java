package group.rxcloud.rmg.publisher;

import group.rxcloud.rmg.domain.Flow;
import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.publisher.domain.MessagePubResponse;

public abstract class MessagePublisher<Req extends MessagePubRequest, Res extends MessagePubResponse>
        implements Flow.Publisher<Req, Res> {
}
