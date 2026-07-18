package com.jobagent.job_agent.resume.parser;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PdfParser {

    public String extractText(String filePath){

        try(PDDocument document = Loader.loadPDF(new File(filePath))){
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to extract text from PDF.");
        }

    }


}
