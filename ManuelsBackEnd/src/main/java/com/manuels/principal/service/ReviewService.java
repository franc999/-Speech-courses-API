package com.manuels.principal.service;

import com.manuels.principal.dao.IReviewDao;
import com.manuels.principal.models.Review;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService{

    @Autowired
    private IReviewDao reviewDao;
    
    @Override
    public List<Review> listReviews() {
        return reviewDao.findAll();
    }

    @Override
    public Review create(Review review) {
        return reviewDao.save(review);
    }

    @Override
    public void delete(Review review) {
        reviewDao.delete(review);
    }

    @Override
    public Review update(Review review) {
        Review existingReview = reviewDao.findById(review.getIdReview()).orElse(null);

        existingReview.setName(review.getName());
        existingReview.setCommentary(review.getCommentary());
        existingReview.setValidate(review.getValidate());
        
        return reviewDao.save(existingReview);
    }

    @Override
    public Review find(Long idReview) {
        return reviewDao.findById(idReview).orElse(null);
    } 
}
