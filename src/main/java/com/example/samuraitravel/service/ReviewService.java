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
        
        review.setName(reviewRegisterForm.getName());                
        review.setDescription(reviewRegisterForm.getDescription());
        review.setRating(reviewRegisterForm.getRating());                
        reviewRepository.save(review);
    }
}
