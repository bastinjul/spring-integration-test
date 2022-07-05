package be.bastinjul.springintegrationtest.config;

import be.bastinjul.springintegrationtest.entities.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Configuration
public class SaveObjectFlow {

    @Bean
    public IntegrationFlow saveObjectIntegrationFlow() {
        return IntegrationFlows
                .from("objectSaverIn")
                .<Object, Class<?>>route(Object::getClass, m -> m
                        .channelMapping(Book.class, "saveBookInDbIn"))
                .get();
    }
}
