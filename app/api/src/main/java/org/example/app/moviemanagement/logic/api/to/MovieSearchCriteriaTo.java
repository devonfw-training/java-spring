package org.example.app.moviemanagement.logic.api.to;

import org.example.app.general.common.api.to.AbstractSearchCriteriaTo;
import org.example.app.moviemanagement.common.api.Movie;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link AbstractSearchCriteriaTo} to find instances of {@link Movie}s.
 */
public class MovieSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String title;

  private String genres;

  private Integer year;

  private StringSearchConfigTo titleOption;

  private StringSearchConfigTo genresOption;

  /**
   * @return titleId
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @param title setter for title attribute
   */
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * @return genresId
   */
  public String getGenres() {

    return this.genres;
  }

  /**
   * @param genres setter for genres attribute
   */
  public void setGenres(String genres) {

    this.genres = genres;
  }

  /**
   * @return yearId
   */
  public Integer getYear() {

    return this.year;
  }

  /**
   * @param year setter for year attribute
   */
  public void setYear(Integer year) {

    this.year = year;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getTitle() title}.
   */
  public StringSearchConfigTo getTitleOption() {

    return this.titleOption;
  }

  /**
   * @param titleOption new value of {@link #getTitleOption()}.
   */
  public void setTitleOption(StringSearchConfigTo titleOption) {

    this.titleOption = titleOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getGenres() genres}.
   */
  public StringSearchConfigTo getGenresOption() {

    return this.genresOption;
  }

  /**
   * @param genresOption new value of {@link #getGenresOption()}.
   */
  public void setGenresOption(StringSearchConfigTo genresOption) {

    this.genresOption = genresOption;
  }

}
