package dev.pia.movies.services;

import java.util.*;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.pia.movies.models.Movie;
import dev.pia.movies.repositories.MovieRepository;

//Business logic - uses the repository to access the database and return the data to the controller
@Service
public class MovieService {

  // instance of MovieRepository
  @Autowired
  private MovieRepository movieRepo;

  // db access methods
  public List<Movie> allMovies() {
    return movieRepo.findAll();
  }

  // use ObjectId to search for movies
  // public Optional<Movie> getMovie(ObjectId id) {
  //   return movieRepo.findById(id);
  // }
  
  // use imdbId to search for movies instead of ObjectId
  public Optional<Movie> getMovie(String imdbId) {
    return movieRepo.findByImdbId(imdbId);
  }
  
}
