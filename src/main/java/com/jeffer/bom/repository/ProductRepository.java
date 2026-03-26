package com.jeffer.bom.repository;

import com.jeffer.bom.model.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository

public class ProductRepository {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Mono<Product> save(Product product) {
        long id = idGenerator.incrementAndGet();
        product.setId(id);
        products.put(id, product);
        return Mono.just(product);
    }

    public Mono<Product> findById(Long id) {
        return Mono.justOrEmpty(products.get(id));
    }
}
