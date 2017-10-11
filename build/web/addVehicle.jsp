<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
    </head>
    <body>
        
        <% Object value = request.getParameter("fleetId"); 
        %> 
        
    <h1> Add Vehical </h1>
        <form action="./VehicleAdd" method="post">
            <table>
                <tr>
                    <td> Vehical PlateNumber: </td>
                    <td><input type="text" name="Vplate" required=""></td>
                    <h4>${requestScope["Error"]}</h4>
                </tr>
                <tr>
                    <td> Vehical RegDate: </td>
                    <td><input type="date" id="datepicker" name="Vdate" required=""></td>
                </tr>
                <tr>
                    <td> Vehical Make: </td>
                    <td><input type="text" name="Vmake" required=""></td>
                </tr>
                <tr>
                    <td> Vehical Model: </td>
                    <td><input type="text" name="Vmodel" required=""></td>
                </tr>
                <tr>
                     <td><input type="hidden" name="value" value="<%=value%>"></td>
                    <td><input type="submit" name="addVehicle" value="Add" ></td>
                    <td><a href="mainMenu.jsp?fleetId=<%=value%>">Back</a></td>
                </tr>
            </table>
            </form>
    </body>
</html>
