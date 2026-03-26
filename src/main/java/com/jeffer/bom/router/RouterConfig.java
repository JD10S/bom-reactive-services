package com.jeffer.bom.router;

import com.jeffer.bom.handler.MaterialHandler;
import com.jeffer.bom.handler.ProductHandler;
import com.jeffer.bom.handler.ProductionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routes(
            ProductHandler productHandler,
            MaterialHandler materialHandler,
            ProductionHandler productionHandler
    ) {
        return route()
                .POST("/products", productHandler::create)
                .POST("/products/{productId}/materials", materialHandler::addMaterial)
                .GET("/production/calculate", productionHandler::calculate)
                .build();
    }
}