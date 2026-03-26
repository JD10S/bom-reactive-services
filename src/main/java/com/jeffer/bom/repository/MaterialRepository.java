package com.jeffer.bom.repository;

import com.jeffer.bom.model.Material;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository

public class MaterialRepository {
    private final List<Material> materials = new CopyOnWriteArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Mono<Material> save(Material material) {
        material.setId(idGenerator.incrementAndGet());
        materials.add(material);
        return Mono.just(material);
    }

    public Flux<Material> findByProductId(Long productId) {
        return Flux.fromIterable(materials)
                .filter(m -> m.getProductId().equals(productId));
    }
}
