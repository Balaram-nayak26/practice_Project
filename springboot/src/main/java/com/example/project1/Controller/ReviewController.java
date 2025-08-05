package com.example.project1.Controller;


import com.example.project1.Service.ReviewService;
import com.example.project1.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService service;

    //get all review
    @GetMapping("/review")
    public List<Review> getAllReview(){
        return service.getAllReview();
    }

    //get review by id
    @GetMapping("/review/{Id}")
    public Review getReviewById(@PathVariable int Id){
        return service.getReviewById(Id);
    }

    //Post method for review
    @PostMapping("/review")
    public void addReview(@RequestBody Review review){
        System.out.println(review);
        service.addReview(review);
    }

    @PutMapping("review/{id}")
    public void updateReview(@PathVariable Integer id, @RequestBody Review review){
        service.updateReview(id, review);
    }

    //Delete method for review
    @DeleteMapping("/review/{Id}")
    public void deleteReview(@PathVariable int Id){
        service.deleteReview(Id);
    }
}
