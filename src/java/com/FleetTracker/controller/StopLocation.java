package com.FleetTracker.controller;

import com.FleetTracker.dto.StopLoc;
import com.FleetTracker.service.FleetServiceImpl;
import com.FleetTracker.service.FleetServiceInt;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

@WebServlet(name = "StopLocation", urlPatterns = {"/StopLocation"})
public class StopLocation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        File file ;
        int maxFileSize = 5000 * 1024;
        int maxMemSize = 5000 * 1024;
        String filePath = "/var/www/html/files/";
        String contentType = request.getContentType();
        String fileName=null;
        
       if ((contentType.indexOf("multipart/form-data") >= 0)) {
           
          DiskFileItemFactory factory = new DiskFileItemFactory();
          factory.setSizeThreshold(maxMemSize);
          
          factory.setRepository(new File("/home/krabimi/NetBeansProjects/temp"));
         // out.println(factory.toString());
          ServletFileUpload upload = new ServletFileUpload(factory);
         
          upload.setSizeMax( maxFileSize );
          try{ 
             List fileItems = upload.parseRequest(request);
             Iterator i = fileItems.iterator();
             out.println("<html>");
             out.println("<body>");
             while ( i.hasNext () ) 
             {
                 
                FileItem fi = (FileItem)i.next();
             
                if ( !fi.isFormField () )  {
                    String fieldName = fi.getFieldName();
                    fileName = fi.getName();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    System.out.println("filename== :"+fileName);
                    file = new File( filePath + fileName) ;
                    System.out.println("hello :"+file.toString());
                    fi.write( file ) ;
                    
                }
             }
             out.println("</body>");
             out.println("</html>");
          }catch(Exception ex) {
             System.out.println(ex);
          }
       }else{
          out.println("<html>");
          out.println("<body>");
          out.println("<p>No file uploaded</p>"); 
          out.println("</body>");
          out.println("</html>");
       }
           
            FileInputStream input = new FileInputStream(filePath+fileName);
            POIFSFileSystem fs = new POIFSFileSystem( input );
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            
            for(int i=0; i<sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                
                 int routeId =  (int) Double.parseDouble(""+row.getCell(0));
                 int stopId =  (int) Double.parseDouble(""+row.getCell(1));         
                 String stopName = ""+row.getCell(2);
                 double stopLat = Double.parseDouble(""+row.getCell(3));
                 double stopLong = Double.parseDouble(""+row.getCell(4));
            
                System.out.println("rout="+routeId);
                System.out.println("stop="+stopId);
                System.out.println("name="+stopName);
                System.out.println("lat="+stopLat);
                System.out.println("long="+stopLong);
          
                //   String stopLat =String.format("%.6f", stopLat1);
               //  String stopLong =String.format("%.6f", stopLong1);
                 
                    StopLoc dto=new StopLoc();
                    dto.setRouteId(routeId);
                    dto.setStopId(stopId);
                    dto.setStopName(stopName);
                    dto.setStopLat(stopLat);
                    dto.setStopLong(stopLong);
                    
                    
                     FleetServiceInt obj = new FleetServiceImpl();
                     int load = obj.stopLocation(dto);
                     System.out.println("Import rows "+i);     
            }
          RequestDispatcher rd  = request.getRequestDispatcher("upload.jsp");
        rd.forward(request, response);
        }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
