package com.FleetTracker.controller;

import com.FleetTracker.dto.QoSDTO;
import com.FleetTracker.dto.StopLoc;
import com.FleetTracker.dto.VehicleLoc;
import com.FleetTracker.service.FleetServiceImpl;
import com.FleetTracker.service.FleetServiceInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QoS", urlPatterns = {"/QoS"})
public class QoS extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String fleetId = request.getParameter("fleetId");
            List<QoSDTO> qosData = new ArrayList();
            FleetServiceInt obj=new FleetServiceImpl();
            qosData = obj.showQoS();
            request.setAttribute("qosData", qosData);
            RequestDispatcher rd  = request.getRequestDispatcher("qos.jsp");
            rd.forward(request, response);
            
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String Uplate = (String) request.getParameter("Vplate");
            FleetServiceInt obj=new FleetServiceImpl();
            List<VehicleLoc> vLocation = new ArrayList();
            vLocation = obj.showLocation();
            
            List<StopLoc> sLocation = new ArrayList();
            sLocation = obj.stopLocation();  
            double minDistance = 50;
           
        String fleetId = request.getParameter("fleetId");
           
      for(int i=0; i<vLocation.size();i++)
            {
                
                String Vplate=vLocation.get(i).getVehiclePlate(); 
                int routeId=vLocation.get(i).getRouteId();
                int tripId=vLocation.get(i).getTripId();
                String date=vLocation.get(i).getDate();
                int speed=vLocation.get(i).getSpeed();
                int id=vLocation.get(i).getId();
                
               
                if(Uplate.equals(Vplate)){
           
                   double vehLat=vLocation.get(i).getVehicleLat();
                    double vehLong=vLocation.get(i).getVehicleLong();
                     
                    //double vehLat= Double.parseDouble(vehLat1);
                    //double vehLong= Double.parseDouble(vehLong1);
                    
                   for(int j=0; j<sLocation.size();j++){
                      
                      double stopLat=sLocation.get(j).getStopLat();
                      double stopLong=sLocation.get(j).getStopLong();
                      
                     // double stopLat=Double.parseDouble(stopLat1);
                     // double stopLong=Double.parseDouble(stopLong1);
                      
                      int stopId=sLocation.get(j).getStopId();
                      String stopName=sLocation.get(j).getStopName();
                      
                      
                        
                 
  double distance =Math.sqrt((vehLat-stopLat)*(vehLat-stopLat) + (vehLong - stopLong)*(vehLong - stopLong))*25484;
   
        if(distance<=minDistance){
              if(speed<=2){   
                 
                  QoSDTO dto=new QoSDTO();
                 
                 dto.setRouteId(routeId); 
                 dto.setRecordId(id);
                 dto.setTripId(tripId);
                 dto.setVehiclePlate(Vplate);
                 dto.setStopId(stopId);
                 dto.setStopName(stopName);
                 dto.setSpeed(speed);
                 dto.setDistance(distance); 
                 dto.setDate(date);
                
               int qos = obj.updateQoS(dto);
               
         
          RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp?fleetId="+fleetId);
             rd.forward(request, response);
             }
        else
                System.out.println("speed dont match");
        }  
        else      
        System.out.println("distance not match");
 } 
              }else
                    System.out.println("sorry Not avialable");
            }
    }

     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
