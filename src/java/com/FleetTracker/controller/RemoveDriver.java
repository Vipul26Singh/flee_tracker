package com.FleetTracker.controller;

import com.FleetTracker.dto.DriverAdd;
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

@WebServlet(name = "RemoveDriver", urlPatterns = {"/RemoveDriver"})
public class RemoveDriver extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            List<DriverAdd> driverList = new ArrayList();
            FleetServiceInt obj=new FleetServiceImpl();
              String fleetId = request.getParameter("fleetId");
            driverList= obj.showAllDriver(fleetId);
            request.setAttribute("driverList",driverList);
            RequestDispatcher rd = request.getRequestDispatcher("removeDriver.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
             FleetServiceInt obj=new FleetServiceImpl();
             int id2 = Integer.parseInt(request.getParameter("DId"));
             int fleetId = Integer.parseInt(request.getParameter("value"));
             DriverAdd dto = new DriverAdd();
             dto.setDId(id2);
             
             int a= obj.deleteDriver(dto);
             RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp?fleetId="+fleetId);
             rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
