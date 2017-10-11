package com.FleetTracker.controller;

import com.FleetTracker.dto.VehicleLoc;
import com.FleetTracker.service.FleetServiceImpl;
import com.FleetTracker.service.FleetServiceInt;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1100177215)    // upload file's size up to 16MB
@WebServlet(name = "LoadLocation", urlPatterns = {"/LoadLocation"})
public class VehicleLocation extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       RequestDispatcher rd  = request.getRequestDispatcher("upload.jsp");
		rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
          try {
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
                    System.out.println("hello shivam :"+file.toString());
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
            POIFSFileSystem fs = new POIFSFileSystem(input);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            Row row;
           
            for(int i=1; i<=sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                
               
                int id = (int) row.getCell(0).getNumericCellValue();
                int routeId = (int) row.getCell(1).getNumericCellValue();
                int tripId = (int) row.getCell(2).getNumericCellValue();
                String vehiclePlate = row.getCell(3).getStringCellValue();
              //System.out.println(row.getCell(4).getDateCellValue().toString());
                Date date1 =  row.getCell(4).getDateCellValue();
                
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String date=sdf.format(date1);
            //   System.out.println(yourDate);
                
                double vehicleLat = row.getCell(5).getNumericCellValue();
                double vehicleLong = row.getCell(6).getNumericCellValue();
              
              //  String vehicleLat =String.format("%.6f", vehicleLat1);
               // String vehicleLong =String.format("%.6f", vehicleLong1);
                
                int speed = (int) row.getCell(7).getNumericCellValue();
                int direction = (int) row.getCell(8).getNumericCellValue();
                    VehicleLoc dto=new VehicleLoc();
             //   System.out.println("flllet"+fleetId);
                dto.setId(id);
                dto. setRouteId(routeId);
                dto.setTripId(tripId);
                dto.setVehiclePlate(vehiclePlate);
                dto.setDate(date);
                dto.setVehicleLat(vehicleLat);
                dto.setVehicleLong(vehicleLong);
                dto.setSpeed(speed);
                dto.setDirection(direction);
              
                
              FleetServiceInt obj = new FleetServiceImpl();
                int load = obj.loadLocation(dto);
               System.out.println("Import rows "+i);     
            }
          
        }catch(IOException ioe){
            System.out.println(ioe);
        } 
     RequestDispatcher rd  = request.getRequestDispatcher("upload.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
