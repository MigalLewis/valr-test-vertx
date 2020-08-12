package za.co.valr.valrtest.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.valr.valrtest.config.ApplicationConfiguration;
import za.co.valr.valrtest.exceptions.BadRequest;
import za.co.valr.valrtest.exceptions.NotFound;
import za.co.valr.valrtest.model.LimitOrder;
import za.co.valr.valrtest.service.ExchangeService;
import za.co.valr.valrtest.service.MarketDataService;

@Component
public class ExchangeVerticle extends AbstractVerticle {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    @Autowired
    private ExchangeService exchangeService;


    @Override
    public void start(Future<Void> fut) throws Exception {
        Vertx vertx = Vertx.factory.vertx();
        Router router = Router.router(vertx);
        router.route("/v1/orders/limit").handler(BodyHandler.create());
        router.post("/v1/orders/limit").handler(this::addOrderLimit);

        vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", applicationConfiguration.httpPort()),
                result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail("it failed");
                    }
                });
    }

    private void addOrderLimit(RoutingContext routingContext) {
        final LimitOrder limitOrder = Json.decodeValue(routingContext.getBodyAsString(),
                LimitOrder.class);
        HttpServerResponse res = routingContext.response();
        res.setStatusCode(200).putHeader("content-type", "application/json").end(exchangeService.addLimitOrder(limitOrder) + "");
    }



}