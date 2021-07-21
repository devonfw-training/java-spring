package org.example.app.moviemanagement.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.moviemanagement.dataaccess.api.MovieEntity;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.usecase.UcManageMovie;
import org.example.app.moviemanagement.logic.base.usecase.AbstractMovieUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for modifying and deleting Movies
 */
@Named
@Validated
@Transactional
public class UcManageMovieImpl extends AbstractMovieUc implements UcManageMovie {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageMovieImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_MOVIE)
  public boolean deleteMovie(long movieId) {

    MovieEntity movie = getMovieRepository().find(movieId);
    getMovieRepository().delete(movie);
    LOG.debug("The movie with id '{}' has been deleted.", movieId);
    return true;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_MOVIE)
  public MovieEto saveMovie(MovieEto movie) {

    Objects.requireNonNull(movie, "movie");

    MovieEntity movieEntity = getBeanMapper().map(movie, MovieEntity.class);

    // initialize, validate movieEntity here if necessary
    MovieEntity resultEntity = getMovieRepository().save(movieEntity);
    LOG.debug("Movie with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, MovieEto.class);
  }

}
