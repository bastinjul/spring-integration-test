package be.bastinjul.springintegrationtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.handler.GenericHandler;

@Configuration
public class MsgTransformationIntegrationConfig {

    @Bean
    public IntegrationFlow msgTransformFlow() {
        return IntegrationFlows
                .from(MessageChannels.direct("transformIn"))
                .<String, String> transform(s -> String.format("Received msg '%s'", s))
                .channel("transformOut")
                .get();
    }

}
