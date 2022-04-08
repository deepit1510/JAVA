package ab;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Document;

public class c {

    private static final String FILE_NAME = "/tmp/itext.pdf";

    public static void main(String[] args) {

        PdfReader reader;

        try {
        	String a ="abcd";
            reader = new PdfReader("C:/Users/deepi/Downloads/ab-protected.pdf",a.getBytes());

            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

            System.out.println(textFromPage);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String readPdfText (File pdfFile, String password) throws IOException {
        try {
            Document pdf;
            if (password == null) {
                // no password, assume the file is unencrypted
                pdf = PDF.open(pdfFile);
            } else {
                pdf = PDF.open(pdfFile, password.getBytes());
            }
            // [... read PDF text, return resulting string ...]
        } catch (EncryptedPDFException e) {
            if (e.getErrorType() == EncryptedPDFException.ErrorType.BadPassword) {
                // return null to indicate that a different password is needed
                return null;
            } else {
                // some error in the decryption process
                // treat just like a regular IOException
                throw e;
            }
        }
    }

}