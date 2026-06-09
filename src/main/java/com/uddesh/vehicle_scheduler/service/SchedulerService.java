package com.uddesh.vehicle_scheduler.service;

import com.uddesh.vehicle_scheduler.algorithm.KnapsackService;
import com.uddesh.vehicle_scheduler.client.ApiClient;
import com.uddesh.vehicle_scheduler.dto.Depot;
import com.uddesh.vehicle_scheduler.dto.DepotResponse;
import com.uddesh.vehicle_scheduler.dto.DepotResult;
import com.uddesh.vehicle_scheduler.dto.VehicleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerService {
    private final ApiClient apiClient;
    private final KnapsackService knapsackService;

    public SchedulerService(
            ApiClient apiClient,
            KnapsackService knapsackService) {
        this.apiClient = apiClient;
        this.knapsackService = knapsackService;
    }

    public List<DepotResult> solve() {
        DepotResponse depotResult = apiClient.getDepots();
        VehicleResponse vehicleResponse = apiClient.getVehicles();

        List<DepotResult> result = new ArrayList<>();

        for (Depot depot : depotResult.getDepots()) {

            int maxImpact = knapsackService.maxImpact(
                    vehicleResponse.getVehicles(),
                    depot.getMechanicHours()
            ).getMaxImpact();

            result.add(
                    new DepotResult(depot.getID(), maxImpact)
            );
        }
        return result;
    }
}
