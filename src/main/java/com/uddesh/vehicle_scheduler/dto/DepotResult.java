package com.uddesh.vehicle_scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepotResult {
    private int deportId;

    private int maxImpact;
}
