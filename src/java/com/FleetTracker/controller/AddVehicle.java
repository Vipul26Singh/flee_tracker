package com.FleetTracker.controller;
import com.FleetTracker.dto.VehicleAdd;
import com.FleetTracker.service.FleetServiceImpl;
import com.FleetTracker.service.FleetServiceInt;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VehicleAdd", urlPatterns = {"/VehicleAdd"})
public class AddVehicle extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
       RequestDispatcher rd  = request.getRequestDispatcher("addVehicle.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
             String Vplate = (String) request.getParameter("Vplate");
             String Vdate = (String) request.getParameter("Vdate");
        //     DateFormat df=new SimpleDateFormat("dd-MMM-yy");
        //     Date Vdate=df.parse(Vdate1);
             String Vmake = (String) request.getParameter("Vmake");
             String Vmodel = (String) request.getParameter("Vmodel");
             int fleetId= Integer.parseInt(request.getParameter("value"));
                   
             VehicleAdd dto = new VehicleAdd();
             dto.setVplate(Vplate);
             dto.setVdate(Vdate);
             dto.setVmake(Vmake);
             dto.setVmodel(Vmodel);
             dto.setFleetId(fleetId);
              
             FleetServiceInt vehicleService = new FleetServiceImpl();
             try {
             
             if(vehicleService.checkVehicle(Vplate)==0){
             vehicleService.insertVehicle(dto);
              String error="Vehicl sucsessfully added";
		request.setAttribute("Error", error);
             RequestDispatcher rd = request.getRequestDispatcher("addVehicle.jsp?fleetId="+fleetId);
             rd.forward(request, response);
             }else {
             String error="Vehicl is already exist!";
             request.setAttribute("Error", error);
             RequestDispatcher rd = request.getRequestDispatcher("addVehicle.jsp?fleetId="+fleetId);
             rd.forward(request, response);
             }
         } catch (Exception ex) {
             Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
         }
             
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
