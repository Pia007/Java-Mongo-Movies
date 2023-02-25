package dev.pia.movies.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dev.pia.movies.services.MovieService;
import dev.pia.movies.models.Movie;

// Controller Layer - handles request from the client and returns a response, uses the service layer to access the database
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

  // reference to the service layer
  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
  }
  
  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId ) {
    return new ResponseEntity<Optional<Movie>>(movieService.getMovie(imdbId), HttpStatus.OK);
  }
  
}
