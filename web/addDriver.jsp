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
    <%Object value = request.getParameter("fleetId");%>
  
     <h1> Add Vehical </h1>
        <form action="./AddDriver" method="post">
            <table>
                
                 <tr>
                    <td> Driver Id: </td>
                    <td><input type="text" name="driverId" maxlength="10" required="">${requestScope["Error"]}</td>
                </tr>
                
                <tr>
                    <td> Driver Name: </td>
                    <td><input type="text" name="driverName" required=""></td>
                </tr>
                <tr>
                    <td> License Id: </td>
                    <td><input type="text" name="licenseId" maxlength="10" required=""></td>
                </tr>
                <tr>
                    <td> PhoneNo: </td>
                    <td><input type="tel" name="phoneNo" maxlength="10" required=""></td>
                </tr>
                <tr>
                    <td> Date of Birth: </td>
                    <td><input type="date" id="datepicker" name="dob" required=""></td>
                </tr>
                <tr>
                    <td> Gender: </td>
                    <td><input type="text" name="gender" list="gender">
                    <datalist id="gender">
                    <option value="Male">
                    <option value="Female">
                    </datalist>
                    </td>
                </tr>
                
                 <tr>
                    <td> Registration Date: </td>
                    <td><input type="date" id="datepicker" name="registrationDate" required=""></td>
                </tr>
                <tr>
                    <td><input type="hidden" name="value" value="<%=value%>"></td>
                    <td><input type="submit" name="addDriver" value="Add"></td>
                         <td><a href="mainMenu.jsp?fleetId=<%=value%>">Back</a></td>
                </tr>
                
            </table>
            </form>
                    
 </body>
</html>
