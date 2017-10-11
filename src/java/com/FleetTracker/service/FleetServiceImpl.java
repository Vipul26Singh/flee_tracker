package com.FleetTracker.service;
import com.FleetTracker.dao.FleetDaoImpl;
import com.FleetTracker.dao.FleetDaoInt;
import com.FleetTracker.dto.DriverAdd;
import com.FleetTracker.dto.FleetAdd;
import com.FleetTracker.dto.QoSDTO;
import com.FleetTracker.dto.StopLoc;
import com.FleetTracker.dto.VehicleLoc;
import com.FleetTracker.dto.VehicleAdd;
import java.util.List;

public class FleetServiceImpl implements FleetServiceInt {
    
    FleetDaoInt dao = new FleetDaoImpl();
   

    @Override
    public int insertVehicle(VehicleAdd dto) throws Exception {
        return dao.insertVehicle(dto); 
        
    }

    @Override
    public List<VehicleAdd> showAllVehicles(String fleetId) {
          return dao.showAllVehicles(fleetId);   
    }

    @Override
    public int deleteVehicle(VehicleAdd dto) {
        return dao.deleteVehicle(dto);
    }

    @Override
    public int addFleet(FleetAdd dto) {
       return dao.addFleet(dto);
    }

     @Override
    public List<FleetAdd> showAllFleets() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.showAllFleets();
    }
    
    @Override
    public int addDriver(DriverAdd dto) {
         return dao.addDriver(dto);
    }

    @Override
    public int deleteDriver(DriverAdd dto) {
            return dao.deleteDriver(dto);
    }

    @Override
    public List<DriverAdd> showAllDriver(String fleetId) {
         return dao.showAllDriver(fleetId);
    }

    @Override
    public int loadLocation(VehicleLoc dto) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.loadLocation(dto);
    }

    @Override
    public int stopLocation(StopLoc dto) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.stopLocation(dto);
    }

    @Override
    public List<VehicleLoc> showLocation() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.showLocation();
    }

    @Override
    public List<StopLoc> stopLocation() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.stopLocation();
    }

    @Override
    public int updateQoS(QoSDTO dto) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.updateQoS(dto);
    }

    @Override
    public List<QoSDTO> showQoS() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return dao.showQoS();
    }

    @Override
    public int checkVehicle(String Vplate) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return dao.checkVehicle(Vplate);
    }

    @Override
    public int checkDriver(String driverId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dao.checkDriver(driverId);
    }

    @Override
    public int checkAssign(String Vplate) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return dao.checkAssign(Vplate);
    }

}
