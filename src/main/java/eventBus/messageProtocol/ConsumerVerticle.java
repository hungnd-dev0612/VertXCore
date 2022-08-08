package eventBus.messageProtocol;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConsumerVerticle extends AbstractVerticle {
    Logger log = LoggerFactory.getLogger(ConsumerVerticle.class);

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        JsonObject json = new JsonObject().put("name", "danghung").put("age", 27);
        vertx.eventBus().consumer("myaddress", msg -> {
//            log.info("consumer received: {}", msg.body());
            log.info("consumer received mess succeeded");
            msg.reply(new JsonObject().put("succeeded", true));

        });
        startFuture.complete();
    }
}
