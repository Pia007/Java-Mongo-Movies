package dev.pia.movies.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;
import dev.pia.movies.models.Movie;


// @Repository not needed, but it's good practice to add it
// repository talks to the db and returns the data to the service layer
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

  // need to use imdbId to search for movies instead of ObjectId
  Optional<Movie> findByImdbId(String imdbId);

  
  
}
