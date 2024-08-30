package com.emo.matrix.lms.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

@Component
public class FileUploadHelper {
	
	// Static
	
	public final String UPLOAD_DIR = "D:\\Office Work\\lms\\lms\\src\\main\\resources\\static\\Video";
	
	
	// Dynamic
//	public final String UPLOAD_DIR;
//	
//	public FileUploadHelper() throws IOException {
//		UPLOAD_DIR = new ClassPathResource("static/video/").getFile().getAbsolutePath();
//	}
	
	
	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean check = false;
		
		try {
			Files.copy(
					multipartFile.getInputStream(), 
					Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING
			);
			
			check = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return check;
		
	}
	
	public String fileName(MultipartFile multipartFile) {
		return multipartFile.getOriginalFilename() ;
	}

}
