package com.uddesh.vehicle_scheduler.client;

import com.uddesh.vehicle_scheduler.dto.DepotResponse;
import com.uddesh.vehicle_scheduler.dto.VehicleResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public DepotResponse getDepots(){
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJ1ZGRlc2hzaW5naDMzQGdtYWlsLmNvbSIsImV4cCI6MTc4MDk5MTQxMywiaWF0IjoxNzgwOTkwNTEzLCJpc3MiOiJBZmZvcmQgTWVkaWNhbCBUZWNobm9sb2dpZXMgUHJpdmF0ZSBMaW1pdGVkIiwianRpIjoiMGFkMzZlNTMtZTRkMS00MjY3LTlmOTgtNGI4NWE5ZjkwZjMyIiwibG9jYWxlIjoiZW4tSU4iLCJuYW1lIjoidWRkZXNoIHByYXRhcCBzaW5naCIsInN1YiI6ImJkYWEwYTk0LTc0N2ItNDIxZC1iY2M5LWViZWJhMjU2ZmQ4OSJ9LCJlbWFpbCI6InVkZGVzaHNpbmdoMzNAZ21haWwuY29tIiwibmFtZSI6InVkZGVzaCBwcmF0YXAgc2luZ2giLCJyb2xsTm8iOiIyMzAwMzIwMTIwMjY0IiwiYWNjZXNzQ29kZSI6ImNYdXFodCIsImNsaWVudElEIjoiYmRhYTBhOTQtNzQ3Yi00MjFkLWJjYzktZWJlYmEyNTZmZDg5IiwiY2xpZW50U2VjcmV0IjoicVpKc2VWWWVTeFlqWHROeCJ9._WjbseqGdovTk27ERUJbBPwt6_xoenoE97yRgYvGs2k";
        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(token);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        System.out.println(headers);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<DepotResponse> response =
                restTemplate.exchange(
                        "http://4.224.186.213/evaluation-service/depots",
                        HttpMethod.GET,
                        entity,
                        DepotResponse.class
                );

        return response.getBody();
    }

    public VehicleResponse getVehicles() {
        HttpHeaders headers = new HttpHeaders();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJ1ZGRlc2hzaW5naDMzQGdtYWlsLmNvbSIsImV4cCI6MTc4MDk5MTQxMywiaWF0IjoxNzgwOTkwNTEzLCJpc3MiOiJBZmZvcmQgTWVkaWNhbCBUZWNobm9sb2dpZXMgUHJpdmF0ZSBMaW1pdGVkIiwianRpIjoiMGFkMzZlNTMtZTRkMS00MjY3LTlmOTgtNGI4NWE5ZjkwZjMyIiwibG9jYWxlIjoiZW4tSU4iLCJuYW1lIjoidWRkZXNoIHByYXRhcCBzaW5naCIsInN1YiI6ImJkYWEwYTk0LTc0N2ItNDIxZC1iY2M5LWViZWJhMjU2ZmQ4OSJ9LCJlbWFpbCI6InVkZGVzaHNpbmdoMzNAZ21haWwuY29tIiwibmFtZSI6InVkZGVzaCBwcmF0YXAgc2luZ2giLCJyb2xsTm8iOiIyMzAwMzIwMTIwMjY0IiwiYWNjZXNzQ29kZSI6ImNYdXFodCIsImNsaWVudElEIjoiYmRhYTBhOTQtNzQ3Yi00MjFkLWJjYzktZWJlYmEyNTZmZDg5IiwiY2xpZW50U2VjcmV0IjoicVpKc2VWWWVTeFlqWHROeCJ9._WjbseqGdovTk27ERUJbBPwt6_xoenoE97yRgYvGs2k";
        headers.setBearerAuth(token);


        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<VehicleResponse> response =
                restTemplate.exchange(
                        "http://4.224.186.213/evaluation-service/vehicles",
                        HttpMethod.GET,
                        entity,
                        VehicleResponse.class
                );

        return response.getBody();
    }
}
