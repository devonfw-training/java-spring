package org.example.app.moviemanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.app.general.logic.base.AbstractComponentFacade;
import org.example.app.moviemanagement.logic.api.Moviemanagement;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.example.app.moviemanagement.logic.api.usecase.UcFindMovie;
import org.example.app.moviemanagement.logic.api.usecase.UcManageMovie;
import org.springframework.data.domain.Page;

/**
 * Implementation of component interface of moviemanagement
 */
@Named
public class MoviemanagementImpl extends AbstractComponentFacade implements Moviemanagement {

  @Inject
  private UcFindMovie ucFindMovie;

  @Inject
  private UcManageMovie ucManageMovie;

  @Override
  public MovieEto findMovie(long id) {

    return this.ucFindMovie.findMovie(id);
  }

  @Override
  public Page<MovieEto> findMovies(MovieSearchCriteriaTo criteria) {

    return this.ucFindMovie.findMovies(criteria);
  }

  @Override
  public MovieEto saveMovie(MovieEto movie) {

    return this.ucManageMovie.saveMovie(movie);
  }

  @Override
  public boolean deleteMovie(long id) {

    return this.ucManageMovie.deleteMovie(id);
  }

}
