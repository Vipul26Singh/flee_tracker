package com.FleetTracker.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VehicleLocation")
public class VehicleLoc implements Serializable {
        
    
    private int id;
    private int routeId;
    private int tripId;
    private String vehiclePlate;
    private String date;
    private double vehicleLat;
    private double vehicleLong;
    private int speed;
    private int direction;
    
    
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getVehicleLat() {
        return vehicleLat;
    }

    public void setVehicleLat(double vehicleLat) {
        this.vehicleLat = vehicleLat;
    }

    public double getVehicleLong() {
        return vehicleLong;
    }

    public void setVehicleLong(double vehicleLong) {
        this.vehicleLong = vehicleLong;
    }

  
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

   
    
}
