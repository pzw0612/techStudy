package com.ifly.edu.pdfbox.sample1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.exceptions.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ReadPdf {
	private PDDocument document = null;
	public static void main(String[] args) throws IOException {
		String file = "E:\\me\\projects\\pdf2csv\\test\\2--0004.pdf";
		ReadPdf parse = new ReadPdf();
		parse.openPDFFile(file);
		}
	public void openPDFFile(String file) throws IOException {
		InputStream is = null;
		File f = new File(file);
		is = new FileInputStream(f);
		this.document = this.parseDocument(is);
		//获取页数
		List pages = this.document.getDocumentCatalog().getAllPages();
		int pageSize = pages.size();
		System.out.println("pdf页数:"+pageSize);
		this.getPdfText();

	}
	public PDDocument parseDocument(InputStream input) throws IOException {
		PDDocument document = PDDocument.load(input);
		if (document.isEncrypted()) {
			try {
				document.decrypt("");
			} catch (CryptographyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return document;
	}
     /*
      * 抽取pdf文本内容
      */
	public void getPdfText() throws IOException {
		PDFTextStripper stripper = new PDFTextStripper();
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
				"E:\\me\\projects\\pdf2csv\\test\\out\\2--0004.txt"));
		BufferedWriter bw = new BufferedWriter(osw);
		stripper.setShouldSeparateByBeads(true);
		stripper.writeText(document, bw);
		bw.close();
		document.close();
	}

}
