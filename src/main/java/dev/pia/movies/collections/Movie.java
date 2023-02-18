package dev.pia.movies.collections;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.*;

// rep each doc in the movies collection
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

  // fields
  @Id
  private ObjectId id;
  private String imdbId;

  private String title;

  private String releaseDate;

  private String trailerLink;

  private String poster;

  private List<String> genres;

  private List<String> backdrops;

  @DocumentReference
  private List<Review> reviews;
  
}
