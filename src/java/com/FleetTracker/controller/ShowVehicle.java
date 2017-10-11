
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

@WebServlet(name = "ShowVehicle", urlPatterns = {"/ShowVehicle"})
public class ShowVehicle extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String fleetId = request.getParameter("fleetId");
       //     System.out.println("value=="+value);
            List<VehicleAdd> vehicleList = new ArrayList();
            FleetServiceInt obj=new FleetServiceImpl();
            vehicleList = obj.showAllVehicles(fleetId);
            request.setAttribute("vehicleList", vehicleList);
            RequestDispatcher rd = request.getRequestDispatcher("showVehicle.jsp");
            rd.forward(request, response);
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
