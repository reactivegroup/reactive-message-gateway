package group.rxcloud.rmg.email.interfaces.aws;

import group.rxcloud.rmg.core.CoreMessagePublisher;
import group.rxcloud.rmg.email.core.domain.SendEmailRequest;
import group.rxcloud.rmg.email.core.domain.SendEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EmailWebfluxAwsInterface {

    @Autowired
    private CoreMessagePublisher<SendEmailRequest, SendEmailResponse> emailPublisher;

    @GetMapping("checkHealth")
    public String checkHealth() {
        return "ok";
    }

    @PostMapping("sendEmail")
    public Mono<SendEmailResponse> sendEmail(@RequestBody SendEmailRequest sendEmailRequest) {
        return emailPublisher.subscribe(sendEmailRequest);
    }
}
