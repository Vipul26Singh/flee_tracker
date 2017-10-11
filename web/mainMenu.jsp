<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
<%Object value = request.getParameter("fleetId"); %>
   
        
           <h3>Fleet tracker:<%=value%> </h3>
           
    <h3>Vehicle Matters</h3>
     
    
                <a href="./VehicleAdd?fleetId=<%=value%>">Add vehicle:</a></br>
                <a href="./ShowVehicle?fleetId=<%=value%>">Display Vehicle List:</a></br>
                <a href="./RemoveVehicle?fleetId=<%=value%>">Remove Vehicle:</a></br>
                <a href="./LoadLocation">Load Location Data:</a></br>
                <a href="./QoS">QoS:</a>
                
          
      
    <h3>Driver Matters</h3>
         
                <a href="./AddDriver?fleetId=<%=value%>">Add Driver:</a></br>
                <a href="./ShowDriver?fleetId=<%=value%>">Display Driver List:</a></br>
                <a href="./RemoveDriver?fleetId=<%=value%>">Remove Driver:</a></br>
                <a href="">Assign Driver:</a></br>
                <a href="dashBoard.jsp">Quit:</a>
    
    </body>
</html>
