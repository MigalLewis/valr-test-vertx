package za.co.valr.valrtest.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.valr.valrtest.config.ApplicationConfiguration;
import za.co.valr.valrtest.service.ValrService;

@Component
public class MarketDataVerticle extends AbstractVerticle {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    @Autowired
    private ValrService valrService;


    @Override
    public void start(Future<Void> fut) throws Exception {
        Vertx vertx = Vertx.factory.vertx();
        Router router = Router.router(vertx);
        router.get("/v1/marketdata/:currencyPair/orderbook").handler(this::getOrderBook);

        vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", applicationConfiguration.httpPort()),
                result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail("it failed");
                    }
                });
    }

    private void getOrderBook(RoutingContext routingContext) {
        String currencyPair = routingContext.request().getParam("currencyPair");
        HttpServerResponse res = routingContext.response();
        res.setStatusCode(200).putHeader("content-type", "application/json").end(valrService.getOrderBook(currencyPair).toString());
    }


}