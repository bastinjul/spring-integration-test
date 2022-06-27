package be.bastinjul.springintegrationtest.integration.gateways;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "transformIn", defaultReplyChannel = "transformOut")
public interface MsgTransformationGateway {
    String transformMsg(String msg);
}
