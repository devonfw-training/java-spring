package org.example.app.moviemanagement.common.api;

import java.util.List;

import org.example.app.general.common.api.ApplicationEntity;

/**
 * An entity describing a movie
 *
 */
public interface Movie extends ApplicationEntity {

  /**
   * @return titleId
   */
  public String getTitle();

  /**
   * @param title setter for title attribute
   */
  public void setTitle(String title);

  /**
   * @return yearId
   */
  public Integer getYear();

  /**
   * @param year setter for year attribute
   */
  public void setYear(Integer year);

  /**
   * @return Ids of the Genres
   */
  public List<Genre> getGenres();

  /**
   * @param genres setter for genres attribute
   */
  public void setGenres(List<Genre> genres);

}
