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
import za.co.valr.valrtest.exceptions.BadRequest;
import za.co.valr.valrtest.exceptions.NotFound;
import za.co.valr.valrtest.service.MarketDataService;

@Component
public class MarketDataVerticle extends AbstractVerticle {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    @Autowired
    private MarketDataService marketDataService;


    @Override
    public void start(Future<Void> fut) throws Exception {
        Vertx vertx = Vertx.factory.vertx();
        Router router = Router.router(vertx);
        router.get("/v1/marketdata/:currencyPair/orderbook").handler(this::getOrderBook);
        router.get("/v1/marketdata/:currencyPair/tradehistory").handler(this::getAllTrades);

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
        try {
            res.setStatusCode(200).putHeader("content-type", "application/json").end(marketDataService.getOrderBook(currencyPair).toString());
        } catch (BadRequest badRequest) {
            res.setStatusCode(400).setStatusMessage(badRequest.getMessage()).end(badRequest.getMessage());
        } catch (NotFound notFound) {
            res.setStatusCode(404).setStatusMessage(notFound.getMessage()).end(notFound.getMessage());
        }
    }

    private void getAllTrades(RoutingContext routingContext) {
        String currencyPair = routingContext.request().getParam("currencyPair");
        HttpServerResponse res = routingContext.response();
        res.setStatusCode(200).putHeader("content-type", "application/json").end(marketDataService.getAllTrades(currencyPair).toString());
    }


}