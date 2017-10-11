package com.FleetTracker.controller;

import com.FleetTracker.dto.DriverAdd;
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

@WebServlet(name = "AddDriver", urlPatterns = {"/AddDriver"})
public class AddDriver extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("addDriver.jsp");
         rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String driverId = (String) request.getParameter("driverId");
        String driverName = (String) request.getParameter("driverName");
        String licenseId = (String) request.getParameter("licenseId");
	String phoneNo = (String) request.getParameter("phoneNo");
        String dob =    (String)  request.getParameter("dob");
      //  DateFormat df=new SimpleDateFormat("dd-MMM-yy");
      //  Date dob=df.parse(dob1);
        String gender = (String) request.getParameter("gender");
        String registrationDate = (String) request.getParameter("registrationDate");
        int fleetId= Integer.parseInt(request.getParameter("value"));
        
              
              DriverAdd dto = new DriverAdd();
               
              dto.setDriverId(driverId);
		dto.setDriverName(driverName);
		dto.setLicenseId( licenseId);
                dto.setPhoneNo(phoneNo);
		dto.setDob(dob);
                dto.setGender(gender);
                dto.setRegistrationDate(registrationDate);
                dto.setFleetId(fleetId);
                
                FleetServiceInt driverService = new FleetServiceImpl();
       
             try {
             
             if(driverService.checkDriver(driverId)==0){
             driverService.addDriver(dto);
             String error="Driver add sucessFully!";
	     request.setAttribute("Error", error);
             RequestDispatcher rd = request.getRequestDispatcher("mainMenu.jsp?fleetId="+fleetId);
             rd.forward(request, response);
             }else {
                 System.out.println("hhhhhhhhh");
                String error="Driver is already exist!";
		request.setAttribute("Error", error);
		 RequestDispatcher rd = request.getRequestDispatcher("addDriver.jsp");
             rd.forward(request, response);
             }
         } catch (Exception ex) {
             Logger.getLogger(AddVehicle.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
