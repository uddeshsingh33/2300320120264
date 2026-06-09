package com.uddesh.vehicle_scheduler.client;

import com.uddesh.vehicle_scheduler.dto.DeportResponse;
import com.uddesh.vehicle_scheduler.dto.VehicleResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public DeportResponse getDeports(){
        return restTemplate.getForObject(
                "http://4.224.186.213.evalution-service/deport",
                DeportResponse.class
        );
    }

    public VehicleResponse getVehicles() {
        return restTemplate.getForObject(
                "http://4.224.186.213/evaluation-service/vehicles",
                VehicleResponse.class
        );
    }
}
