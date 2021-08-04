package com.manuels.principal.service;

import com.manuels.principal.models.Review;
import java.util.List;

public interface IReviewService {
    
    public List<Review> listReviews();
    
    public Review create(Review review);
    
    public void delete(Review review);
    
    public Review update(Review review);
    
    public Review find(Long idReview);
    
    public Review setTrue(Long idReview);
}
