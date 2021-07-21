package org.example.app.moviemanagement.common.api;

import org.example.app.general.common.api.ApplicationEntity;

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
   * @return genresId
   */
  public String getGenres();

  /**
   * @param genres setter for genres attribute
   */
  public void setGenres(String genres);

}
