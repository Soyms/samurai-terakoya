package com.example.samuraitravel.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.repository.ReviewRepository;
import com.example.samuraitravel.review.ReviewRegisterForm;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;    
    
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;        
    }    
    
    @Transactional
    public void create(ReviewRegisterForm reviewRegisterForm) {
    	Review review = new Review();        
        MultipartFile imageFile = reviewRegisterForm.getImageFile();
        
        if (!imageFile.isEmpty()) {
            String imageName = imageFile.getOriginalFilename(); 
            String hashedImageName = generateNewFileName(imageName);
            Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
            copyImageFile(imageFile, filePath);
            review.setImageName(hashedImageName);
        }
        
        review.setName(reviewRegisterForm.getName());                
        review.setDescription(reviewRegisterForm.getDescription());
        review.setRating(reviewRegisterForm.getRating());
        review.setCapacity(reviewRegisterForm.getCapacity());
        review.setPostalCode(reviewRegisterForm.getPostalCode());
        review.setAddress(reviewRegisterForm.getAddress());
        review.setPhoneNumber(reviewRegisterForm.getPhoneNumber());
                    
        reviewRepository.save(Review);
    }  
    
    // UUIDを使って生成したファイル名を返す
    public String generateNewFileName(String fileName) {
        String[] fileNames = fileName.split("\\.");                
        for (int i = 0; i < fileNames.length - 1; i++) {
            fileNames[i] = UUID.randomUUID().toString();            
        }
        String hashedFileName = String.join(".", fileNames);
        return hashedFileName;
    }     
    
    // 画像ファイルを指定したファイルにコピーする
    public void copyImageFile(MultipartFile imageFile, Path filePath) {           
        try {
            Files.copy(imageFile.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }          
    } 
}