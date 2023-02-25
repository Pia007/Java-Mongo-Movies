package dev.pia.movies.services;

import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.pia.movies.models.Movie;
import dev.pia.movies.models.Review;
import dev.pia.movies.repositories.ReviewRepository;

@Service
public class ReviewService {

  // reference to the review repository
  @Autowired
  private ReviewRepository reviewRepo;

  // mongoTemplates is a class that allows us to run queries against the db
  @Autowired
  private MongoTemplate mongoTemplate;
  
  public Review createReview(String reviewBody, String imdbId ) {
    // instantiate a new review object and save the review to the db
    // Review review = reviewRepo.insert(new Review(reviewBody));
    Review review = reviewRepo.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));
    
    /* 
    Associate the review with the movie
      - need a template for this
      - perform an update on the movie class or collection and push the review id into the reviewIds array
        then matching to match the imdbId from db to the one received from the user
        then apply the update reviewIds array by pushing the review iinto the array
        then first() to only update the first movie that matches the criteria
    */
    mongoTemplate.update(Movie.class)
      .matching(Criteria.where("imdbId").is(imdbId))
      .apply(new Update().push("reviewIds").value(review))
      .first();
    
    return review;

  }
}
