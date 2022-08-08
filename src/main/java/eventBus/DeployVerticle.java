package eventBus;

import eventBus.messageProtocol.ConsumerVerticle;
import eventBus.messageProtocol.ProducerVerticle;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeployVerticle {
    static Logger log = LoggerFactory.getLogger(DeployVerticle.class);
    public static void main(String[] args) {
        log.info("log something");
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ConsumerVerticle());
        vertx.deployVerticle(new ProducerVerticle());

    }
}
