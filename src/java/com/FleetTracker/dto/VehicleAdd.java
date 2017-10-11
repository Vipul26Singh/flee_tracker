package com.FleetTracker.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicles")
public class VehicleAdd implements Serializable  {

   private int VId;
   private String Vplate;
   private String Vdate;
   private String Vmake;
   private String Vmodel;
   private int fleetId;

    @Id
    @GeneratedValue
    @Column(name = "Vehicle_ID")
    public int getVId() {
        return VId;
    }

    public void setVId(int VId) {
        this.VId = VId;
    }
    
    public String getVplate() {
        return Vplate;
    }

    public void setVplate(String Vplate) {
        this.Vplate = Vplate;
    }

    public String getVdate() {
        return Vdate;
    }

    public void setVdate(String Vdate) {
        this.Vdate = Vdate;
    }

    public String getVmake() {
        return Vmake;
    }

    public void setVmake(String Vmake) {
        this.Vmake = Vmake;
    }

    public String getVmodel() {
        return Vmodel;
    }

    public void setVmodel(String Vmodel) {
        this.Vmodel = Vmodel;
    }

    public int getFleetId() {
        return fleetId;
    }

    public void setFleetId(int fleetId) {
        this.fleetId = fleetId;
    }
    
}


