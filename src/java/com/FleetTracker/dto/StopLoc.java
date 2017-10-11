package com.FleetTracker.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stoplocation")
public class StopLoc implements Serializable {

 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int routeId;        
    private int stopId;         
    private String stopName;    
    private double stopLat;      
    private double stopLong; 


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

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public double getStopLat() {
        return stopLat;
    }

    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLong() {
        return stopLong;
    }

    public void setStopLong(double stopLong) {
        this.stopLong = stopLong;
    }

}
