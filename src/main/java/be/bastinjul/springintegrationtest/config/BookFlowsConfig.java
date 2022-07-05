package be.bastinjul.springintegrationtest.config;

import be.bastinjul.springintegrationtest.api.BookController;
import be.bastinjul.springintegrationtest.entities.Book;
import be.bastinjul.springintegrationtest.repositories.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Configuration
public class BookFlowsConfig {

    @Bean
    public IntegrationFlow saveBookInDbFlow(BookRepository bookRepository) {
        return IntegrationFlows
                .from(saveBookInDbIn())
                .<Book> handle((payload, headers) -> bookRepository.save(payload))
                .<Book> handle((payload, headers) -> {
                    payload.add(linkTo(methodOn(BookController.class).getBook(payload.getId())).withSelfRel());
                    return payload;
                })
                .channel("objectSaverOut")
                .get();
    }

    @Bean
    public MessageChannel saveBookInDbIn() {
        return new DirectChannel();
    }
}
