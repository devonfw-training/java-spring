package org.example.app.moviemanagement.dataaccess.api;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.example.app.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.app.moviemanagement.common.api.Genre;
import org.example.app.moviemanagement.common.api.Movie;

/**
 */
@Entity
@Table(name = "MOVIE")
public class MovieEntity extends ApplicationPersistenceEntity implements Movie {

  private static final long serialVersionUID = 1L;

  private String title;

  private Integer year;

  private List<Genre> genres;

  @Override
  public String getTitle() {

    return this.title;
  }

  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  @Override
  @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "MOVIE_GENRE", joinColumns = @JoinColumn(name = "MOVIE_ID"))
  @Column(name = "GENRE", nullable = false)
  @Enumerated(EnumType.STRING)
  public List<Genre> getGenres() {

    return this.genres;
  }

  @Override
  public void setGenres(List<Genre> genres) {

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
