package org.example.app.moviemanagement.logic.impl.usecase;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.moviemanagement.dataaccess.api.MovieEntity;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.example.app.moviemanagement.logic.api.usecase.UcFindMovie;
import org.example.app.moviemanagement.logic.base.usecase.AbstractMovieUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for searching, filtering and getting Movies
 */
@Named
@Validated
@Transactional
public class UcFindMovieImpl extends AbstractMovieUc implements UcFindMovie {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindMovieImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE)
  public MovieEto findMovie(long id) {

    LOG.debug("Get Movie with id {} from database.", id);
    Optional<MovieEntity> foundEntity = getMovieRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), MovieEto.class);
    else
      return null;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE)
  public Page<MovieEto> findMovies(MovieSearchCriteriaTo criteria) {

    Page<MovieEntity> movies = getMovieRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(movies, MovieEto.class);
  }

}
