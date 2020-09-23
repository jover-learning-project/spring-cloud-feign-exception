package com.questionbank.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@SpringBootApplication
public class QuestionBankGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionBankGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route(p ->
                        p.path("/question_bank")
                                .filters(f -> f.stripPrefix(1))
                                .uri("lb://question-bank-composite")
                ).build();
    }

}
