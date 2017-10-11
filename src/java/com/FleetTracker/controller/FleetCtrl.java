package com.FleetTracker.controller;

import com.FleetTracker.dto.FleetAdd;
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

@WebServlet(name = "FleetCtrl", urlPatterns = {"/FleetCtrl"})
public class FleetCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             if(request.getParameter("addfleet")!=null){
             String fleetName = (String) request.getParameter("fleetName");
             FleetAdd dto = new FleetAdd();
             dto.setFleetName(fleetName);
            
             FleetServiceInt createFleet = new FleetServiceImpl();
             int i=createFleet.addFleet(dto);
             int fleetId=dto.getFleetId();
             String fleetname=dto.getFleetName();
             
             request.setAttribute("fleetname", fleetname);
             System.out.println("success");
             RequestDispatcher rd = request.getRequestDispatcher("dashBoard.jsp");
             rd.forward(request, response);
             
        }
  
             if(request.getParameter("showfleet")!=null){
               List<FleetAdd> fleetList = new ArrayList();
               FleetServiceInt obj=new FleetServiceImpl();
               fleetList = obj.showAllFleets();
               request.setAttribute("fleetList", fleetList);
               RequestDispatcher rd = request.getRequestDispatcher("showFleet.jsp");
               rd.forward(request, response);
             
             }
             
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
