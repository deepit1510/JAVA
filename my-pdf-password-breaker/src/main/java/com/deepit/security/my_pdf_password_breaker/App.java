package com.deepit.security.my_pdf_password_breaker;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class App {
    //private static final String FILE_NAME = "/tmp/itext.pdf";

    public static void main(String[] args) {

        PdfReader reader;

        try {
        	String a = "abcd";
            reader = new PdfReader("C:/Users/deepi/Downloads/ab-protected.pdf",a.getBytes());

            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

            System.out.println(textFromPage);

            reader.close();

        } catch (IOException e) {
            //e.printStackTrace();
        }

    }

}