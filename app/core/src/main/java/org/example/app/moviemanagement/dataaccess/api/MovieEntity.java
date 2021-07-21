package org.example.app.moviemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.example.app.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.app.moviemanagement.common.api.Movie;

/**
 */
@Entity
@Table(name = "MOVIE")
public class MovieEntity extends ApplicationPersistenceEntity implements Movie {

  private static final long serialVersionUID = 1L;

  private String title;

  private Integer year;

  private String genres;

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  @Override
  public String getGenres() {

    return this.genres;
  }

  @Override
  public void setGenres(String genres) {

    this.genres = genres;
  }

  @Override
  public Integer getYear() {

    return this.year;
  }

  @Override
  public void setYear(Integer year) {

    this.year = year;
  }

}
