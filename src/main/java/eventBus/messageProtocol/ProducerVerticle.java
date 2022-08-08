package eventBus.messageProtocol;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerVerticle extends AbstractVerticle {
    Logger log = LoggerFactory.getLogger(ProducerVerticle.class);

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        JsonObject json = new JsonObject().put("name", "dang hung").put("address", "43/3 duong 5 Tang Nhon Phu B, q9");
//        EventBus eb = vertx.eventBus();
        vertx.eventBus().send("myaddress", "mess", handler -> {
            handler.result();
            if (handler.succeeded()) {
                log.info("producer sending message success {}",handler.result().body());
            } else {
                log.info("producer fail ", handler.failed());
                log.error("something wrong with producer ", handler.cause());
                handler.cause();
            }
        });
        startFuture.complete();
    }
}
