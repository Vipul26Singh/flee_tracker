package com.FleetTracker.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fleets")
public class FleetAdd implements Serializable {

 private int fleetId;
 private String fleetName;
 
    @Id 
    @GeneratedValue
    @Column(name = "Fleet_ID")
    public int getFleetId() {
        return fleetId;
    }

    public void setFleetId(int fleetId) {
        this.fleetId = fleetId;
    }
   
    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }
   
}
