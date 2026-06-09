package com.uddesh.vehicle_scheduler.algorithm;

import com.uddesh.vehicle_scheduler.dto.KnapsackResult;
import com.uddesh.vehicle_scheduler.dto.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class KnapsackService {

    public KnapsackResult maxImpact(
            List<Vehicle> vehicles,
            int capacity) {

        int n = vehicles.size();

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {

            int duration = vehicles.get(i - 1).getDuration();
            int impact = vehicles.get(i - 1).getImpact();

            for (int h = 0; h <= capacity; h++) {

                // Don't take vehicle
                dp[i][h] = dp[i - 1][h];

                // Take vehicle if possible
                if (duration <= h) {

                    dp[i][h] = Math.max(
                            dp[i][h],
                            impact + dp[i - 1][h - duration]
                    );
                }
            }
        }

        // Reconstruct selected tasks
        List<String> selectedTasks = new ArrayList<>();

        int h = capacity;

        for (int i = n; i > 0; i--) {

            if (dp[i][h] != dp[i - 1][h]) {

                Vehicle vehicle = vehicles.get(i - 1);

                selectedTasks.add(vehicle.getTaskID());

                h -= vehicle.getDuration();
            }
        }

        Collections.reverse(selectedTasks);

        return new KnapsackResult(
                dp[n][capacity],
                selectedTasks
        );
    }
}