package dev.shegs.certificateGenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.ServletOutputStream;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.awt.*;
import java.io.IOException;

@Service
public class PDFService {

    public void PDFGenerator(ServletOutputStream response, String fullName) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response);

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("This is the title", fontTitle);
        paragraph.setAlignment(paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES);
        fontParagraph.setSize(12);

        Paragraph bodyParagraph = new Paragraph("This is the body paragraph of the pdf which is set to a font size of 12 and a font type of TIMES", fontParagraph);
        bodyParagraph.setAlignment(paragraph.ALIGN_LEFT);

        Paragraph bodyParagraph2 = new Paragraph("This is the second body paragraph of the pdf which is set to a font size of 12 and a font type of TIMES", fontParagraph);
        bodyParagraph2.setAlignment(paragraph.ALIGN_LEFT);

        Paragraph userNameParagraph = new Paragraph(fullName);
        userNameParagraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);
        document.add(bodyParagraph);
        document.add(bodyParagraph2);
        document.add(userNameParagraph);
        document.close();

    }

}
