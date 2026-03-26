package com.jeffer.bom.service;

import com.jeffer.bom.model.MaterialResult;
import com.jeffer.bom.model.ProductionResult;
import com.jeffer.bom.repository.MaterialRepository;
import com.jeffer.bom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductionService {
    private final ProductRepository productRepository;
    private final MaterialRepository materialRepository;

    public Mono<ProductionResult> calculate(Long productId, int quantity) {

        return productRepository.findById(productId)
                .switchIfEmpty(Mono.error(new RuntimeException("Producto no encontrado")))
                .flatMap(product ->
                        materialRepository.findByProductId(productId)
                                .map(material -> new MaterialResult(
                                        material.getMaterial(),
                                        material.getQuantity() * quantity
                                ))
                                .collectList()
                                .map(materials -> new ProductionResult(
                                        product.getName(),
                                        quantity,
                                        materials
                                ))
                );
    }
}
