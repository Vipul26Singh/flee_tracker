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

@WebServlet(name = "ShowDriver", urlPatterns = {"/ShowDriver"})
public class ShowDriver extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<DriverAdd> driverList = new ArrayList();
            FleetServiceInt obj=new FleetServiceImpl();
              String fleetId = request.getParameter("fleetId");
            driverList= obj.showAllDriver(fleetId);
            request.setAttribute("driverList",driverList);
            RequestDispatcher rd = request.getRequestDispatcher("showDriver.jsp");
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
