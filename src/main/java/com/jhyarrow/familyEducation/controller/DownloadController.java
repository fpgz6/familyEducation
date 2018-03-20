package com.jhyarrow.familyEducation.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhyarrow.familyEducation.service.QuestionService;

@Controller
public class DownloadController {
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download() throws Exception{
		String path = questionService.getQuestion();
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", "caculate.pdf"); 
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);    
	}
}
