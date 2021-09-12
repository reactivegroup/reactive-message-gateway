package group.rxcloud.rmg.processor;

import group.rxcloud.rmg.domain.Flow;
import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.publisher.domain.MessagePubResponse;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;

public abstract class MessageProcessor<
        PReq extends MessagePubRequest, PRes extends MessagePubResponse,
        SReq extends MessageSubRequest, SRes extends MessageSubResponse>
        implements Flow.Processor<PReq, PRes, SReq, SRes> {
}
