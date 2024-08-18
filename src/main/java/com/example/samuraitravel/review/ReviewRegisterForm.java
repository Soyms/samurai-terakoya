package com.example.samuraitravel.review;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRegisterForm {
	 @NotBlank(message = "評価を入力してください。")
     private String name;
         
     
     
     @NotBlank(message = "コメントを入力してください。")
     private String description;   
     
    
}
