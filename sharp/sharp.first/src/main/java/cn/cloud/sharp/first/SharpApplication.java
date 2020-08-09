package cn.cloud.sharp.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import io.vertx.core.Vertx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.cloud.sharp.second.TestApi;

import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@RestController
@EnableFeignClients
public class SharpApplication {

	public static void main(String[] args) {

		SpringApplication.run(SharpApplication.class, args);
	}

	@RequestMapping("/")
    public String index() {
        return "Hello";
	}

	@RequestMapping("/call")
    public String call() {
		vertx.eventBus().<String>request("cn.cloud.sharp.first.call", "Event callGreen2", reply -> {});
        return "Hello" + new TestApi().add(1, 5);
	}
	
	@Value("${server.port2}")
	protected Integer port2;

	@Autowired
	protected Vertx vertx;

	@EventListener
	void deployVerticles(ApplicationReadyEvent event) {
		vertx.createHttpServer().requestHandler(req -> req.response().end("Hello World!")).listen(port2);
		vertx.eventBus().<String>consumer("cn.cloud.sharp.first.call").handler(reply -> {
			// reply.reply(reply.body());
        });
	}

}
