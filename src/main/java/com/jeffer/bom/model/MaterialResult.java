package com.jeffer.bom.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaterialResult {
    private String material;
    private int required;
}

