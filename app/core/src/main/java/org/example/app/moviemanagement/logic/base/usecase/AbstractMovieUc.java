package org.example.app.moviemanagement.logic.base.usecase;

import javax.inject.Inject;

import org.example.app.general.logic.base.AbstractUc;
import org.example.app.moviemanagement.dataaccess.api.repo.MovieRepository;

/**
 * Abstract use case for Movies, which provides access to the commonly necessary data access objects.
 */
public class AbstractMovieUc extends AbstractUc {

  /** @see #getMovieRepository() */
  @Inject
  private MovieRepository movieRepository;

  /**
   * Returns the field 'movieRepository'.
   * 
   * @return the {@link MovieRepository} instance.
   */
  public MovieRepository getMovieRepository() {

    return this.movieRepository;
  }

}
