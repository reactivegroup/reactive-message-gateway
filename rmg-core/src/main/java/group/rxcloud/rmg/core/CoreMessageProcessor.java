package group.rxcloud.rmg.core;

import group.rxcloud.rmg.processor.MessageProcessor;
import group.rxcloud.rmg.publisher.domain.MessagePubRequest;
import group.rxcloud.rmg.publisher.domain.MessagePubResponse;
import group.rxcloud.rmg.subscriber.domain.MessageSubRequest;
import group.rxcloud.rmg.subscriber.domain.MessageSubResponse;

public abstract class CoreMessageProcessor<PReq extends MessagePubRequest, PRes extends MessagePubResponse,
        SReq extends MessageSubRequest, SRes extends MessageSubResponse>
        extends MessageProcessor<PReq, PRes, SReq, SRes> {
}
