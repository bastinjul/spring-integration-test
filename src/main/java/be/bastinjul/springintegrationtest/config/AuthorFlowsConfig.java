package be.bastinjul.springintegrationtest.config;

import be.bastinjul.springintegrationtest.api.AuthorController;
import be.bastinjul.springintegrationtest.entities.Author;
import be.bastinjul.springintegrationtest.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Link;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageChannel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Configuration
public class AuthorFlowsConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorFlowsConfig.class);

    @Bean
    public IntegrationFlow saveAuthorFlow() {
        return IntegrationFlows
                .from(MessageChannels.direct("saveAuthorIn"))
                .channel("saveAuthorInDbIn")
                .get();
    }

    @Bean
    public IntegrationFlow addHateoasAuthorFlow() {
        return IntegrationFlows
                .from("saveAuthorInDbOut")
                .channel("addHateoasAuthorIn")
                .get();
    }

    @Bean
    public IntegrationFlow returnAuthor() {
        return IntegrationFlows
                .from("addHateoasAuthorOut")
                .channel("saveAuthorOut")
                .get();
    }

    @Bean
    @ServiceActivator(inputChannel = "saveAuthorInDbIn", outputChannel = "saveAuthorInDbOut")
    public GenericHandler<Author> saveAuthorInDbHandler(AuthorRepository repository) {
        LOGGER.info("Saving author in DB in flow");
        return ((payload, headers) -> repository.save(payload));
    }

    @Bean
    @ServiceActivator(inputChannel = "addHateoasAuthorIn", outputChannel = "addHateoasAuthorOut")
    public GenericHandler<Author> addHateoasAuthor() {
        LOGGER.info("Adding hateoas link to author");
        return ((payload, headers) -> {
            Link link = linkTo(methodOn(AuthorController.class).getAuthor(payload.getId())).withSelfRel();
            payload.add(link);
            return payload;
        });
    }

    @Bean
    public MessageChannel saveAuthorInDbIn() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel saveAuthorInDbOut() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel addHateoasAuthorIn() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel addHateoasAuthorOut() {
        return new DirectChannel();
    }
}
