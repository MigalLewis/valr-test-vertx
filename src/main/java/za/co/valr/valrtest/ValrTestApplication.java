package za.co.valr.valrtest;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.valr.valrtest.verticles.MarketDataVerticle;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class ValrTestApplication {
	@Autowired
	private MarketDataVerticle marketDataVerticle;

	public static void main(String[] args) {
		SpringApplication.run(ValrTestApplication.class,args);
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(marketDataVerticle);
	}

}
