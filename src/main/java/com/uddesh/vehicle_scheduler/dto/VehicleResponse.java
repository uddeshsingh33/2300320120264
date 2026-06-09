package com.uddesh.vehicle_scheduler.dto;

import lombok.Data;

import java.util.List;

@Data
public class VehicleResponse {
    private List<Vehicle> vehicles;
}
