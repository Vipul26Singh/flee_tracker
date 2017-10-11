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
          
All Employees: <br> 
<table border="1">
    <thead><th>Vehicle ID</th>
    <th>Vehicle Plate No</th>
    <th>Vehicle Registration Date</th>
    <th>Vehicle Make</th>
    <th>Vehicle Model</th>
</thead>
<tbody>
             
        <c:forEach var="vehicle" items="${vehicleList}">
             <tr>
          <td> ${vehicle.getVId()}   </td>
          <td> ${vehicle.getVplate()}</td>
          <td> ${vehicle.getVdate()} </td>
          <td> ${vehicle.getVmake()} </td>
          <td> ${vehicle.getVmodel()}</td>
           </tr>
        </c:forEach>
         
</tbody>
            </table>

 <form action="./RemoveVehicle" method="post">
            <select name="VId">
                <c:forEach items="${vehicleList}" var="vehicle">
                <option value="${vehicle.getVId()}">${vehicle.getVId()}</option>
                 </c:forEach>
            </select>
            <input type="hidden" name="value" value="<%=value%>">
            <button type="submit" name="deleteVehicle"> Delete </button>
            <a href="mainMenu.jsp?fleetId=<%=value%>">Back</a>
        </form>
 </body>
</html>