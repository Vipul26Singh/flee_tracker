package com.FleetTracker.dao;

import com.FleetTracker.dto.DriverAdd;
import com.FleetTracker.dto.FleetAdd;
import com.FleetTracker.dto.QoSDTO;
import com.FleetTracker.dto.StopLoc;
import com.FleetTracker.dto.VehicleLoc;
import com.FleetTracker.dto.VehicleAdd;
import com.FleetTraker.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FleetDaoImpl implements FleetDaoInt {  
    
    @Override
    public int insertVehicle(VehicleAdd dto) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dto);
	tx.commit();
	System.out.println("sucessfully registerd!");
	session.close();
        return 0;
}

    @Override
    public List<VehicleAdd> showAllVehicles(String fleetId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<VehicleAdd> vehicleList = new ArrayList();
         Session session = HibernateUtil.getSessionFactory().openSession();
         Query query = session.createQuery("From VehicleAdd where fleetId="+fleetId);
         vehicleList = query.list();
         return vehicleList; 
    }

    @Override
    public int deleteVehicle(VehicleAdd dto) {
         
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(dto);
        tx.commit();
        System.out.println("sucessfully delete!");
        session.close();
        return 0;
    }

    @Override
    public int addFleet(FleetAdd dto) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dto);
	tx.commit();
	System.out.println("sucessfully add fleet");
	session.close();
        return 0; 
    }

    @Override
    public int addDriver(DriverAdd dto) {
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dto);
	tx.commit();
	System.out.println("sucessfully registerd!");
	session.close();
        return 0;
    }

    @Override
    public List<DriverAdd> showAllDriver(String fleetId) {
        List<DriverAdd> driverList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From DriverAdd where fleetId="+fleetId);
        driverList = query.list();
        return driverList; 
    }

    @Override
    public int deleteDriver(DriverAdd dto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(dto);
        tx.commit();
        System.out.println("sucessfully delete!");
        session.close();
        return 0;
    }

    @Override
    public List<FleetAdd> showAllFleets() {
        List<FleetAdd> fleetList = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From FleetAdd ");
        fleetList = query.list();
        return fleetList;  
    }

    @Override
    public int loadLocation(VehicleLoc dto) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dto);
        tx.commit();
        System.out.println("sucessfully import!");
        session.close();
        return 0;
    
    }

    @Override
    public int stopLocation(StopLoc dto) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dto);
        tx.commit();
        System.out.println("sucessfully import!");
        session.close();
        return 0;
    }

    @Override
    public List<VehicleLoc> showLocation() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<VehicleLoc> location = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From VehicleLoc");
        location = query.list();
        return location; 
    }

    @Override
    public List<StopLoc> stopLocation() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<StopLoc> location1 = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From StopLoc");
        location1 = query.list();
        return location1; 
    
    }

    @Override
    public int updateQoS(QoSDTO dto) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dto);
	tx.commit();
	System.out.println("sucessfully insert!");
	session.close();
        return 0;
    
    }

    @Override
    public List<QoSDTO> showQoS() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<QoSDTO> qos = new ArrayList();
         Session session = HibernateUtil.getSessionFactory().openSession();
         Query query = session.createQuery("From QoSDTO ");
         qos = query.list();
         return qos; 
    
    }

    @Override
    public int checkVehicle(String Vplate) {
     //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    Query query = session.createQuery("from VehicleAdd where Vplate = :Vplate");
    query.setParameter("Vplate", Vplate);
    query.uniqueResult();
  
    if(query.uniqueResult()!=null){
    return 1;
    }else
    return 0;
    
    }

    @Override
    public int checkDriver(String driverId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    Query query = session.createQuery("from DriverAdd where driverId = :driverId");
    query.setParameter("driverId", driverId);
    query.uniqueResult();
  
    if(query.uniqueResult()!=null){
    return 1;
    }else
    return 0;
    
    }   

    @Override
    public int checkAssign(String Vplate) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction tx = session.beginTransaction();
    Query query = session.createQuery("from Assign where  = :Vplate");
    query.setParameter("Vplate", Vplate);
    query.uniqueResult();
  
    if(query.uniqueResult()!=null){
    return 1;
    }else
    return 0;
    
    }
}
