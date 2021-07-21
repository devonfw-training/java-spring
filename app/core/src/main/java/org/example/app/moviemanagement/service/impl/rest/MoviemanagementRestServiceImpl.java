package org.example.app.moviemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.app.moviemanagement.logic.api.Moviemanagement;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.example.app.moviemanagement.service.api.rest.MoviemanagementRestService;
import org.springframework.data.domain.Page;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Moviemanagement}.
 */
@Named("MoviemanagementRestService")
public class MoviemanagementRestServiceImpl implements MoviemanagementRestService {

  @Inject
  private Moviemanagement moviemanagement;

  @Override
  public MovieEto getMovie(long id) {

    return this.moviemanagement.findMovie(id);
  }

  @Override
  public MovieEto saveMovie(MovieEto movie) {

    return this.moviemanagement.saveMovie(movie);
  }

  @Override
  public void deleteMovie(long id) {

    this.moviemanagement.deleteMovie(id);
  }

  @Override
  public Page<MovieEto> findMovies(MovieSearchCriteriaTo searchCriteriaTo) {

    return this.moviemanagement.findMovies(searchCriteriaTo);
  }

}
