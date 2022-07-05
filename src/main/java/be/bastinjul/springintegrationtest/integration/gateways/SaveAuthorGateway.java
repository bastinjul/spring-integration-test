package be.bastinjul.springintegrationtest.integration.gateways;

import be.bastinjul.springintegrationtest.entities.Author;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "saveAuthorIn", defaultReplyChannel = "saveAuthorOut")
public interface SaveAuthorGateway {
    Author saveAuthor(Author objectToSave);
}
