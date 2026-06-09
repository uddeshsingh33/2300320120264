package com.uddesh.vehicle_scheduler.controller;

import com.uddesh.vehicle_scheduler.client.ApiClient;
import com.uddesh.vehicle_scheduler.dto.DepotResponse;
import com.uddesh.vehicle_scheduler.dto.VehicleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final ApiClient apiClient;

    public TestController(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    @GetMapping("/test/depots")
    public DepotResponse depots(){
        return apiClient.getDepots();
    }

    @GetMapping("/test/vehicles")
    public VehicleResponse vehicles(){
        return apiClient.getVehicles();
    }

}
