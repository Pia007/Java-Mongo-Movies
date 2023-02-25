package dev.pia.movies.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import dev.pia.movies.models.Review;

public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
  
}
