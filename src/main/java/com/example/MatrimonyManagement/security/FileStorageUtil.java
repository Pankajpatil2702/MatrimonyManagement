package com.example.MatrimonyManagement.security;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

@Configuration
public class FileStorageUtil {

	@Value("${file.upload-dir")
	private String uploadDir;
	
	public String saveFile(MultipartFile file) {
		
		try {
			
			String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
			
			Path uploadPath = Paths.get(uploadDir);
			
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			
			Path filePath = uploadPath.resolve(fileName);
			
			Files.copy(file.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
			
			return filePath.toString();
			
		} catch (Exception e) {
			
			throw new RuntimeException("File upload filed", e);
			
		}
		
	}
	
}
