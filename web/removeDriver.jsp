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
            
All Drivers: <br> 
<table border="1">
    <thead><th>DId</th>
    <th>Driver ID</th>
    <th>Driver Name:</th>
    <th>License Id:</th>
    <th>PhoneNo:</th>
    <th>Date of Birth:</th>
    <th>Gender:</th>
    <th>Registration Date:</th>
</thead>
<tbody>
           
        <c:forEach var="driver" items="${driverList}">
             <tr>
           <td> ${driver.getDId()}   </td>
          <td> ${driver.getDriverId()}   </td>
          <td> ${driver.getDriverName()}</td>
          <td> ${driver.getLicenseId()} </td>
          <td> ${driver.getPhoneNo()}</td>
          <td> ${driver.getDob()} </td>
          <td> ${driver.getGender()}</td>
          <td> ${driver.getRegistrationDate()}</td>
           </tr>
        </c:forEach>
         
</tbody>
            </table>

            <form action="./RemoveDriver" method="post">
           
                <select name="DId">
                <c:forEach items="${driverList}" var="driver">
                <option value="${driver.getDId()}">${driver.getDId()}</option>
                </c:forEach>
                </select>
             <input type="hidden" name="value" value="<%=value%>">
            <button type="submit" name="deleteDriver"> Delete </button>
            <a href="mainMenu.jsp?fleetId=<%=value%>">Back</a>      
        </form>
 
 </body>
</html>