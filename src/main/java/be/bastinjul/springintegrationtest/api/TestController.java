package be.bastinjul.springintegrationtest.api;

import be.bastinjul.springintegrationtest.integration.gateways.MsgTransformationGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private final MsgTransformationGateway msgTransformationGateway;

    public TestController(MsgTransformationGateway msgTransformationGateway) {
        this.msgTransformationGateway = msgTransformationGateway;
    }

    @GetMapping(value = "/testMsg/{msg}")
    public String test(@PathVariable String msg) {
        LOGGER.info(msg);
        return msgTransformationGateway.transformMsg(msg);
    }
}
