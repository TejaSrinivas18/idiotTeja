package com.temple.util;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.temple.model.Temple;
 
public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Temple> listTemples;
     
    public ExcelExporter(List<Temple> listTemples)
    {
        this.listTemples = listTemples;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Temples");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Temple ID", style);      
        createCell(row, 1, "Temple Name", style);       
        createCell(row, 2, "Temple History", style); 
        createCell(row, 3, "Festival Name", style); 
        createCell(row, 4, "Festival Date", style);  
        createCell(row, 5, "Street", style);
        createCell(row, 6, "Area", style);
        createCell(row, 7, "City", style);
        createCell(row, 8, "State", style);
        createCell(row, 9, "Pincode", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) 
    {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Temple temple : listTemples) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, temple.getTempleId(), style);
            createCell(row, columnCount++, temple.getTempleName(), style);
            createCell(row, columnCount++, temple.getTempleHistory(), style);
            createCell(row, columnCount++, temple.getFestival().getFestivalName(), style);
            createCell(row, columnCount++, temple.getFestival().getFestivalDate(), style);
            createCell(row, columnCount++, temple.getPlace().getStreet(), style);
            createCell(row, columnCount++, temple.getPlace().getArea().toString(), style);
            createCell(row, columnCount++, temple.getPlace().getCity(), style);
            createCell(row, columnCount++, temple.getPlace().getState(), style); 
            createCell(row, columnCount++, temple.getPlace().getPincode(), style);
            
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}



//
//String s1="";
//for (FoodCategory list : listFoodCategory) 
//{
//int size=list.getItemTimings().size();
//
//for(int i=0;i<size;i++)
//{
//String s=list.getItemTimings().get(i).getCategories();
//s1=s+"   "+s1;
//}
////System.out.println(s1);
//    Row row = sheet.createRow(rowCount++);
//    int columnCount = 0;
//    createCell(row, columnCount++, list.getItemId(), style);
//    createCell(row, columnCount++, list.getItemName(), style);
//    createCell(row, columnCount++, list.getItemPrice().toString(), style);
//    createCell(row, columnCount++, list.getItemCategory().getCategoryType(), style);
//    createCell(row, columnCount++, list.getItemCategory().getCategoryname(), style);
//    createCell(row, columnCount++, s1, style);
//    
//    s1=""; 
//}
//}