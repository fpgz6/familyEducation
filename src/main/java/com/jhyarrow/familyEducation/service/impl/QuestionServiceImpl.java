package com.jhyarrow.familyEducation.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.jhyarrow.familyEducation.service.QuestionService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class QuestionServiceImpl implements QuestionService{
	private String[]formula = new String[]{"+","-"};
	
	public String getQuestion() {
		String path = this.getClass().getClassLoader().getResource("").getPath()+"caculate.pdf";
		File file = new File(path);
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			Document document = new Document(); 
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open(); 
			for(int i=0;i<20;i++) {
				document.add(new Paragraph(getCaculate())); 
			}
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return path;
	}
	
	public String getCaculate() {
		int a = 1+(int)(Math.random()*20);
		int b = 1+(int)(Math.random()*20);
		int c = 1+(int)(Math.random()*20);
		int d = 1+(int)(Math.random()*20);
		String tmpA = "";
		String tmpB = "";
		String tmpC = "";
		String tmpD = "";
		if(a<10) {
			if(a == 1) {
				tmpA = "";
			}else {
				tmpA = String.valueOf(a);
			}
		}else {
			tmpA = String.valueOf(a);
		}
		if(b<10) {
			if(b == 1) {
				tmpB = "";
			}else {
				tmpB = String.valueOf(b);
			}
		}else {
			tmpB = String.valueOf(b);
		}
		if(c<10) {
			if(c == 1) {
				tmpC = "";
			}else {
				tmpC = String.valueOf(c);
			}
		}else {
			tmpC = String.valueOf(c);
		}
		if(d<10) {
			if(d == 1) {
				tmpD = "";
			}else {
				tmpD = String.valueOf(d);
			}
		}else {
			tmpD = String.valueOf(d);
		}
		
		String tmp = tmpA + "(x" + formula[(int)(Math.random()*2)] + tmpB +")"+ formula[(int)(Math.random()*2)]
				+tmpC+"(y"+formula[(int)(Math.random()*2)]+tmpD+") = 0";
		return tmp;
	}

}
