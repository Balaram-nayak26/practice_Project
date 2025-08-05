package com.example.project1.Service;


import com.example.project1.Repo.ReviewRepo;
import com.example.project1.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo repo;


    //get all
    public List<Review> getAllReview() {
        return repo.findAll();
    }

    //get by id
    public Review getReviewById(int id) {
        return repo.findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst().get();
    }

    //post
    public void addReview(Review review) {
        repo.save(review);
    }

    // update
    public void updateReview(Integer id, Review updatedReview){
        Optional<Review> optionalReview = repo.findById(id);

        if ( optionalReview.isPresent()){
            Review existingReview = optionalReview.get();

            if (updatedReview.getRating() != null){
                existingReview.setRating((updatedReview.getRating()));
            }
            if (updatedReview.getComment() != null){
                existingReview.setComment((updatedReview.getComment()));
            }
            if (updatedReview.getDate() != null){
                existingReview.setDate((updatedReview.getDate()));
            }
            if (updatedReview.getCourseEnrollment() != null){
                existingReview.setCourseEnrollment((updatedReview.getCourseEnrollment()));
            }

            repo.save(existingReview);
        }
    }

    //delete
    public void deleteReview(int id) {
        repo.deleteById(id);
    }
}
