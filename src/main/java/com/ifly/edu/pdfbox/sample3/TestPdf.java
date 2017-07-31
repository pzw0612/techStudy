package com.ifly.edu.pdfbox.sample3;

import java.io.FileInputStream;



import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;

public class TestPdf {
	public static void main(String[] args) throws Exception{
	    FileInputStream fis = new FileInputStream("E:\\me\\projects\\pdf2csv\\test\\2--0004.pdf");
	    PDFParser p = new PDFParser(fis);
	    
	  
	    p.parse();    
	    PDFTextStripper ts = new PDFTextStripper();    
	    ts.setStartPage(1);
	    ts.setEndPage(1);
	    String s = ts.getText(p.getPDDocument());
	    System.out.println(s);
	    fis.close();
	  }
	

}
