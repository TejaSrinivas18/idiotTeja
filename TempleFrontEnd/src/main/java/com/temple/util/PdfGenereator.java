package com.temple.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.temple.model.Temple;

public class PdfGenereator {

    public static void templeDetailReport(HttpServletResponse response, List<Temple> temple) throws IOException {

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument;
        pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        try {
        
            for(Temple temp:temple)
            {
            	document.add(new Paragraph(temp.toString()));
            }

            //document.add(text);

            document.close();
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void templeDetailReportById(HttpServletResponse response, Temple temple) throws IOException {

        PdfWriter writer = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument;
        pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        try {
        
//            for(Temple temp:temple)
//            {
//            	document.add(new Paragraph(temp.toString()));
//            }
            document.add(new Paragraph(temple.toString()));
            //document.add(text);

            document.close();
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}








//document.add(new Paragraph(hotel.toString()));

//Text text=new Text(null);
//text.addStyle((Style) hotel);
//
//Table table = new Table(new float[]{20f, 50f, 30F});
//table.setWidthPercent(100)
//        .setPadding(0)
//        .setFontSize(9);
//
//Cell cell1 = new Cell(1,3);
//cell1.setTextAlignment(TextAlignment.CENTER);
//cell1.add("Hotel Details").setBold();
//table.addCell(cell1);
//
//table.addCell(new Cell().add("Id").setBold());
//table.addCell(new Cell().add("Name").setBold());
//table.addCell(new Cell().add("AREA").setBold());