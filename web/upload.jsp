<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%Object value = request.getParameter("fleetId");%>
      <div>
     <div >
        <h1> Upload data</h1>
        <form method="post" action="./LoadLocation" enctype="multipart/form-data">
                  
                    <div>
                   <label>Load Vehicle Location Data</label></br>
                   <div style="padding-top: 10px"><input type="file"  name="filename" required/>
                       <input type="hidden" name="value" value="<%=value%>">
                       <input type="submit" value="Upload"></div>
                   </div>
              </form>
        
         <form method="post" action="./StopLocation" enctype="multipart/form-data">
            
             <div style="padding-top:50px; padding-bottom: 20px"> 
                 <label>Load Stop Location Data</label> </br>
                  <div style="padding-top: 10px"> <input type="file"  name="file" required/>
                  <input type="hidden" name="value" value="<%=value%>">
                  <input type="submit" value="Upload"></div>
                 <a href="mainMenu.jsp?fleetId=<%=value%>">Back</a>
             </div>
              </form>
          
        
      </div>
      </div>
    </body>
</html>
