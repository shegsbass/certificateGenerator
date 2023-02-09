package dev.shegs.certificateGenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import jakarta.servlet.ServletOutputStream;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class PDFService {

    private static final String certificateTitle = "Certificate of Attendance";
    private static final String presentText = "This is presented to";
    private static final String certForText = "To certify the attendance of Sustainable Energy Days Conference, that was held on 3rd Dec 2022";
    private static final String designatorName = "Ogbonna Chibunna";
    private static final String designation = "Managing Director, SED Conference";
    private static final String issueDateText = "Date Issued";

    public void PDFGenerator(ServletOutputStream response, String certRecipientName) throws IOException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response);

        document.open();

        Image background = Image.getInstance("src/main/resources/background.png");
        background.setAbsolutePosition(0, -100);
        background.scalePercent(70);
        background.setAlignment(Image.ALIGN_CENTER);


        Image logo = Image.getInstance("src/main/resources/logo.png");
        logo.setAbsolutePosition(350, 500);
        logo.scalePercent(15);
        logo.setAlignment(Image.ALIGN_CENTER);


        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 32, Color.BLUE);
        Paragraph certTitle = new Paragraph("\n" + "\n" + "\n" + certificateTitle, fontTitle);
        certTitle.setAlignment(certTitle.ALIGN_CENTER);


        Font fontPresent = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 14, Color.BLACK);
        Paragraph paragraphPresent = new Paragraph(presentText, fontPresent);
        paragraphPresent.setAlignment(paragraphPresent.ALIGN_CENTER);

        // Add recipient name to certificate
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, Color.BLACK);
        Paragraph recipient = new Paragraph("\n" + "\n" + certRecipientName, font);
        recipient.setAlignment(Element.ALIGN_CENTER);

        // Add a line under the paragraph
        LineSeparator separator = new LineSeparator();
        separator.setLineColor(Color.BLACK);
        separator.setLineWidth(0.1f);
        separator.setPercentage(50);

        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES, 12,Color.BLACK);
        Paragraph certFor = new Paragraph("\n" + certForText, fontParagraph);
        certFor.setAlignment(certFor.ALIGN_CENTER);

        Font fontDesignator = FontFactory.getFont(FontFactory.TIMES_BOLD, 12,Color.BLACK);
        Paragraph designatorTitle = new Paragraph("\n" + "\n" + "\n" + "\n" + designatorName, fontDesignator);
        designatorTitle.setAlignment(designatorTitle.ALIGN_LEFT);

        Font fontDesignation = FontFactory.getFont(FontFactory.TIMES_ITALIC, 12,Color.BLACK);
        Paragraph designationTitle = new Paragraph(designation, fontDesignation);
        designationTitle.setAlignment(designationTitle.ALIGN_LEFT);


        LocalDate todaysDate = LocalDate.now();
        Paragraph downloadDate = new Paragraph(String.valueOf(todaysDate), fontParagraph);
        downloadDate.setAlignment(downloadDate.ALIGN_RIGHT);

        Paragraph dateIssuedTitle = new Paragraph(issueDateText, fontParagraph);
        dateIssuedTitle.setAlignment(dateIssuedTitle.ALIGN_RIGHT);
        // Add a line under the paragraph
        LineSeparator separator2 = new LineSeparator();
        separator2.setLineColor(Color.BLACK);
        separator2.setAlignment(Element.ALIGN_RIGHT);
        separator2.setLineWidth(0.1f);
        separator2.setPercentage(8);

        document.add(background);
        document.add(logo);

        document.add(certTitle);

        document.add(paragraphPresent);

        document.add(recipient);
        document.add(separator);

        document.add(certFor);

        document.add(designatorTitle);
        document.add(designationTitle);

        document.add(downloadDate);
        document.add(separator2);
        document.add(dateIssuedTitle);
        document.close();

    }

}
