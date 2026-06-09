package com.uddesh.vehicle_scheduler.algorithm;

import com.uddesh.vehicle_scheduler.dto.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnapsackService {
    public int maxImpact(List<Vehicle> vehicles, int capacity){
        int n = vehicles.size();
        int[][] dp = new int[n + 1][capacity + 1];
        for(int i = 1; i <= n; i++) {
            int duration = vehicles.get(i - 1).getDuration();

            int impact = vehicles.get(i - 1).getImpact();

            for(int h = 0; h <= capacity; h++) {

                dp[i][h] = dp[i - 1][h];

                if(duration <= h) {

                    dp[i][h] = Math.max(dp[i][h], impact + dp[i - 1][h - duration]
                    );
                }
            }
        }

        return dp[n][capacity];
    }
}