package com.jeffer.bom.handler;

import com.jeffer.bom.model.Material;
import com.jeffer.bom.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MaterialHandler {

    private final MaterialRepository repository;

    public Mono<ServerResponse> addMaterial(ServerRequest request) {
        Long productId = Long.valueOf(request.pathVariable("productId"));

        return request.bodyToMono(Material.class)
                .map(material -> {
                    material.setProductId(productId);
                    return material;
                })
                .flatMap(repository::save)
                .flatMap(saved -> ServerResponse.ok().bodyValue(saved));
    }
}