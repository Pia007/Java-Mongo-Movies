package dev.pia.movies.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.pia.movies.models.Movie;
import dev.pia.movies.repositories.MovieRepository;


@Service
public class MovieService {

  // instance of MovieRepository
  @Autowired
  private MovieRepository movieRepo;

  // db access methods
  public List<Movie> allMovies() {
    return movieRepo.findAll();
  }

  // use imdbId to search for movies instead of ObjectId
  public Optional<Movie> getMovie(String imdbId) {
    return movieRepo.findByImdbId(imdbId);
  }
  
}
