package com.FleetTracker.service;
import com.FleetTracker.controller.QoS;
import com.FleetTracker.dto.DriverAdd;
import com.FleetTracker.dto.FleetAdd;
import com.FleetTracker.dto.QoSDTO;
import com.FleetTracker.dto.StopLoc;
import com.FleetTracker.dto.VehicleLoc;
import com.FleetTracker.dto.VehicleAdd;
import java.util.List;

public interface FleetServiceInt {
    
    public int insertVehicle(VehicleAdd dto) throws Exception; 
    public int deleteVehicle(VehicleAdd dto);
    public List<VehicleAdd> showAllVehicles(String fid);
    
    public int addFleet(FleetAdd dto);
    public List<FleetAdd> showAllFleets();
    
    public int addDriver(DriverAdd dto);
    public int deleteDriver(DriverAdd dto);
    public List<DriverAdd> showAllDriver(String fid);

    public int loadLocation(VehicleLoc dto);
    public int stopLocation(StopLoc dto);
    public List<VehicleLoc> showLocation();
    public List<StopLoc> stopLocation();
    public int updateQoS(QoSDTO dto);
    public List<QoSDTO> showQoS();

    public int checkVehicle(String Vplate);

    public int checkDriver(String driverId);

    public int checkAssign(String Vplate);

   

  
    
    
}
