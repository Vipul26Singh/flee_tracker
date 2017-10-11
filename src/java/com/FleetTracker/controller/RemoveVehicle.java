
package com.FleetTracker.controller;

import com.FleetTracker.dto.VehicleAdd;
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

@WebServlet(name = "RemoveVehicle", urlPatterns = {"/RemoveVehicle"})
public class RemoveVehicle extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
            String fleetId = request.getParameter("fleetId");
            List<VehicleAdd> vehicleList = new ArrayList();
            FleetServiceInt obj=new FleetServiceImpl();
            vehicleList = obj.showAllVehicles(fleetId);
            request.setAttribute("vehicleList", vehicleList);
            RequestDispatcher rd = request.getRequestDispatcher("removeVehicle.jsp");
            rd.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
   
            System.out.println("hello");
            FleetServiceInt obj=new FleetServiceImpl();
            VehicleAdd dto = new VehicleAdd();
            String Vplate =  (String) request.getParameter("Vplate");
          //  System.out.println("hello=="+Vplate);
            int id3 =  Integer.parseInt(request.getParameter("VId"));
            int fleetId = Integer.parseInt(request.getParameter("value"));
            dto.setVId(id3);

            int i=obj.deleteVehicle(dto);
             System.out.println("successfully");
            RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp?fleetId="+fleetId);
            rd.forward(request, response);
            
            
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
