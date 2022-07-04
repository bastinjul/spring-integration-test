package be.bastinjul.springintegrationtest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHandler;

@Configuration
public class MsgTransformationIntegrationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgTransformationIntegrationConfig.class);

    @Bean
    public IntegrationFlow msgTransformFlow() {
        return IntegrationFlows
                .from(MessageChannels.direct("transformIn"))
                .<String, String> transform(s -> String.format("Received msg '%s'", s))
                .channel("logIn")
                .channel("transformOut")
                .get();
    }

    @Bean
    @ServiceActivator(inputChannel = "logIn")
    public MessageHandler logActivator() {
        return (message -> LOGGER.info((String) message.getPayload()));
    }

}
