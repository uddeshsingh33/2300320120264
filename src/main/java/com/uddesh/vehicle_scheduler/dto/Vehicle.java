package com.uddesh.vehicle_scheduler.dto;

import lombok.Data;

@Data
public class Vehicle {

    private String TaskID;

    private int Duration;

    private int Impact;

    public String getTaskID() {
        return TaskID;
    }

    public int getDuration() {
        return Duration;
    }

    public int getImpact() {
        return Impact;
    }
}