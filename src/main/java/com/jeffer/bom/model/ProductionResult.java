package com.jeffer.bom.model;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductionResult {
    private String product;
    private int quantity;
    private List<MaterialResult> materials;
}
