package com.jeffer.bom.handler;

import com.jeffer.bom.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductionHandler {

    private final ProductionService service;

    public Mono<ServerResponse> calculate(ServerRequest request) {
        Long productId = Long.valueOf(request.queryParam("productId").orElse("0"));
        int quantity = Integer.parseInt(request.queryParam("quantity").orElse("0"));

        return service.calculate(productId, quantity)
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }
}