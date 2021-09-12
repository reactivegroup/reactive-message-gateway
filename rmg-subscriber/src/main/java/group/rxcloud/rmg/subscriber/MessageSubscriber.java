package group.rxcloud.rmg.subscriber;

import group.rxcloud.rmg.domain.Flow;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;

public abstract class MessageSubscriber<Req extends MessageSubRequest, Res extends MessageSubResponse>
        implements Flow.Subscriber<Req, Res> {
}
