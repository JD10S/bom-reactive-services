package com.jeffer.bom.handler;

import com.jeffer.bom.model.Product;
import com.jeffer.bom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductRepository repository;

    public Mono<ServerResponse> create(ServerRequest request) {
        return request.bodyToMono(Product.class)
                .flatMap(repository::save)
                .flatMap(product -> ServerResponse.ok().bodyValue(product));
    }
}