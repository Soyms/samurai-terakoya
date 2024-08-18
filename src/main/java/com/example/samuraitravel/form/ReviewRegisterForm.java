package com.example.samuraitravel.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRegisterForm {
	@NotBlank(message = "評価してください。")
    private String rating;
        
    private MultipartFile imageFile;
    
    @NotBlank(message = "コメントしてください")
    private String description;   
         
}
