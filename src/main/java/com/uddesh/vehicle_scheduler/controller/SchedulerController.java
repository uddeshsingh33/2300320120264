package com.uddesh.vehicle_scheduler.controller;

import com.uddesh.vehicle_scheduler.dto.DepotResult;
import com.uddesh.vehicle_scheduler.service.SchedulerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerController(
            SchedulerService schedulerService) {

        this.schedulerService =
                schedulerService;
    }

    @GetMapping
    public List<DepotResult> solve() {

        return schedulerService.solve();
    }
}