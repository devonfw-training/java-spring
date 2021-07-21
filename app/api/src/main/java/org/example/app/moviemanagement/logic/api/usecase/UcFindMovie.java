package org.example.app.moviemanagement.logic.api.usecase;

import java.util.List;

import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.springframework.data.domain.Page;

public interface UcFindMovie {

  /**
   * Returns a Movie by its id 'id'.
   *
   * @param id The id 'id' of the Movie.
   * @return The {@link MovieEto} with id 'id'
   */
  MovieEto findMovie(long id);

  /**
   * Returns a paginated list of Movies matching the search criteria.
   *
   * @param criteria the {@link MovieSearchCriteriaTo}.
   * @return the {@link List} of matching {@link MovieEto}s.
   */
  Page<MovieEto> findMovies(MovieSearchCriteriaTo criteria);

}
