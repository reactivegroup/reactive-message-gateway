package group.rxcloud.rmg.domain;

import reactor.core.publisher.Mono;

/**
 * <pre>
 * Flow:
 *             [       Publisher      ]  [        Processor         ]                    [ Subscriber ]    (AWS/Alibaba/...)
 *
 * [WEB API] → ([PReq] → publish → ...)  ([PReq] → inbound  → [SReq])  →  SYNC/Async  →  ([SReq] → ...)
 *
 * [WEB API] ← ([PRes] ← publish ← ...)  ([PRes] ← outbound ← [SRes])  ←  SYNC/Async  ←  ([SRes] ← ...)
 * </pre>
 */
public interface Flow {

    /**
     * The Message Publisher.
     *
     * @param <PReq> the upstream request type
     * @param <PRes> the upstream response type
     */
    interface Publisher<PReq, PRes> {

        /**
         * Publish upstream message to {@link Processor}.
         *
         * @param request the upstream request
         * @return the upstream response mono
         */
        Mono<PRes> subscribe(PReq request);
    }

    /**
     * The Message Subscriber.
     *
     * @param <SReq> the downstream request type
     * @param <SRes> the downstream response type
     */
    interface Subscriber<SReq, SRes> {

        /**
         * Process downstream request from {@link Processor}.
         *
         * @param request the downstream request
         * @return the downstream response mono
         */
        Mono<SRes> onNext(SReq request);
    }

    /**
     * The Message Processor.
     */
    interface Processor<PReq, PRes, SReq, SRes> {

        /**
         * Process upstream request to downstream request.
         *
         * @param upstreamRequest the upstream request
         * @return the downstream request mono
         */
        Mono<SReq> inbound(PReq upstreamRequest);

        /**
         * Process downstream response to upstream response.
         *
         * @param downstreamResponse the downstream response
         * @return the upstream response mono
         */
        Mono<PRes> outbound(SRes downstreamResponse);
    }
}
