<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    </head>
    <body>
     <% Object value = request.getParameter("fleetId");%> 
            Quality Of Service:<br> 
<table border="1">
    <thead>
    <th>Route Id</th>
    <th>Trip Id</th>
    <th>Vehicle plate</th>
    <th>Stop Id</th>
    <th>Stop Name</th>
    <th>Speed</th>
    <th>Distance</th>
    <th>Date</th>
</thead>
<tbody>
             
        <c:forEach var="qos" items="${qosData}">
             <tr>
          <td> ${qos.getRouteId()}   </td>
          <td> ${qos.getTripId()}</td>
          <td> ${qos.getVehiclePlate()} </td>
          <td> ${qos.getStopId()} </td>
          <td> ${qos.getStopName()}</td>
          <td> ${qos.getSpeed()} </td>
          <td> ${qos.getDistance()}</td>
          <td> ${qos.getDate()}</td>
           </tr>
        </c:forEach>
        
</tbody>
 </table>
        
   <form method="post" action="./QoS">
            Enter Vehicle Plate No:<input type="text" name="Vplate" placeholder="Enter" required=""/></br>
             
            <input type="submit" value="Submit">
            <a href="mainMenu.jsp?fleetId=<%=value%>">Back</a>
        </form>
 
    </body>
</html>
