package com.uddesh.vehicle_scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KnapsackResult {
    private int maxImpact;
    private List<String> selectedTasks;
}
