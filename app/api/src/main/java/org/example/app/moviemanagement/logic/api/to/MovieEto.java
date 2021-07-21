package org.example.app.moviemanagement.logic.api.to;

import org.example.app.moviemanagement.common.api.Movie;

import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Movie
 */
public class MovieEto extends AbstractEto implements Movie {

  private static final long serialVersionUID = 1L;

  private String title;

  private String genres;

  private Integer year;

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

    return year;
  }

  @Override
  public void setYear(Integer year) {

    this.year = year;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
    result = prime * result + ((this.year == null) ? 0 : this.year.hashCode());
    result = prime * result + ((this.genres == null) ? 0 : this.genres.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    MovieEto other = (MovieEto) obj;
    if (this.title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!this.title.equals(other.title)) {
      return false;
    }
    if (this.year == null) {
      if (other.year != null) {
        return false;
      }
    } else if (!this.year.equals(other.year)) {
      return false;
    }
    if (this.genres == null) {
      if (other.genres != null) {
        return false;
      }
    } else if (!this.genres.equals(other.genres)) {
      return false;
    }
    return true;
  }

}
