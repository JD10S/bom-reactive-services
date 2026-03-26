package com.jeffer.bom.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Material {
    private Long id;
    private Long productId;
    private String material;
    private int quantity;
}
