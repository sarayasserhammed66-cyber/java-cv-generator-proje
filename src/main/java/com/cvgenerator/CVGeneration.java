package com.cvgenerator;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.File;

public class CVGeneration {

    public static void createPDF(Person person, String outputPath) {
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Font styles
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 10);

            // Header Table (Personal Details + Profile Picture)
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{3, 1});

            PdfPCell infoCell = new PdfPCell();
            infoCell.setBorder(Rectangle.NO_BORDER);
            infoCell.addElement(new Paragraph(person.getFullName(), titleFont));
            infoCell.addElement(new Paragraph("Email: " + person.getEmail(), normalFont));
            infoCell.addElement(new Paragraph("Phone: " + person.getPhone(), normalFont));

            headerTable.addCell(infoCell);

            // Add Image
            PdfPCell imageCell = new PdfPCell();
            imageCell.setBorder(Rectangle.NO_BORDER);

            File imageFile = new File(person.getImagePath());
            if (imageFile.exists()) {
                Image profileImg = Image.getInstance(person.getImagePath());
                profileImg.scaleToFit(90, 90);
                imageCell.addElement(profileImg);
            } else {
                imageCell.addElement(new Paragraph("[Profile Image]", normalFont));
            }
            headerTable.addCell(imageCell);

            document.add(headerTable);
            document.add(new Paragraph("\n"));

            // Section: Work Experience
            Paragraph expHeader = new Paragraph("WORK EXPERIENCE", sectionFont);
            expHeader.setSpacingAfter(10);
            document.add(expHeader);

            for (WorkExperience exp : person.getExperiences()) {
                Paragraph jobTitle = new Paragraph(exp.getJobTitle() + " - " + exp.getCompanyName(), boldFont);
                Paragraph duration = new Paragraph("Duration: " + exp.getDuration(), normalFont);
                Paragraph desc = new Paragraph(exp.getDescription(), normalFont);
                desc.setSpacingAfter(10);

                document.add(jobTitle);
                document.add(duration);
                document.add(desc);
            }

            document.close();
            System.out.println("CV PDF successfully generated at: " + outputPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}