<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <form action="./FleetCtrl" method="post">
                <input type="text" name="fleetName" placeholder="fleet Name" required=""/>
            <input type="submit" name="addfleet" value="create"/>
        </form>
    </body>
</html>
