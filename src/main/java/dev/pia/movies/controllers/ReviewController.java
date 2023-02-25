package dev.pia.movies.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.pia.movies.models.Review;
import dev.pia.movies.services.ReviewService;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {

  // the review form will be inside the movie details page, make the request to
  // the movies endpoint

  @Autowired
  private ReviewService reviewService;

  /*
   * convert the req body to a map of key string and value string and call it
   * payload
   * 
   */

  @PostMapping
  public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
    return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    // return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"));
    // return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"), HttpStatus.CREATED));

  }

}
