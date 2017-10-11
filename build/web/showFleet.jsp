<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        
    </head>
    <body>
        <table border="1">
    <thead>
    <th>Fleet ID</th>
    <th>Fleet Name</th>
</thead>
<tbody>
             
        <c:forEach var="fleet" items="${fleetList}">
             <tr>
       <td>  ${fleet.getFleetId()}  </td>
          <td> <a href="mainMenu.jsp?fleetId=${fleet.getFleetId()}"> ${fleet.getFleetName()} </a></td>
           </tr>
        </c:forEach>
         
</tbody>
            </table>
    </body>
</html>
