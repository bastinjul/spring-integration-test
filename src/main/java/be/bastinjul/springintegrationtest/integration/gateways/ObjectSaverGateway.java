package be.bastinjul.springintegrationtest.integration.gateways;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "objectSaverIn", defaultReplyChannel = "objectSaverOut")
public interface ObjectSaverGateway {
    Object saveObject(Object object);
}
