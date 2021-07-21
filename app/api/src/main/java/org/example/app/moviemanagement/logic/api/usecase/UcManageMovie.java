package org.example.app.moviemanagement.logic.api.usecase;

import org.example.app.moviemanagement.logic.api.to.MovieEto;

/**
 * Interface of UcManageMovie to centralize documentation and signatures of methods.
 */
public interface UcManageMovie {

  /**
   * Deletes a movie from the database by its id 'movieId'.
   *
   * @param movieId Id of the movie to delete
   * @return boolean <code>true</code> if the movie can be deleted, <code>false</code> otherwise
   */
  boolean deleteMovie(long movieId);

  /**
   * Saves a movie and store it in the database.
   *
   * @param movie the {@link MovieEto} to create.
   * @return the new {@link MovieEto} that has been saved with ID and version.
   */
  MovieEto saveMovie(MovieEto movie);

}
