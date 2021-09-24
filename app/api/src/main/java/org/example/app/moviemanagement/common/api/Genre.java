package org.example.app.moviemanagement.common.api;

/**
 * Movie genres
 */
public enum Genre {

  /** Genre ACTION. */
  ACTION("Action"),

  /** Genre ADVENTURE. */
  ADVENTURE("Adventure"),

  /** Genre ANIMATION. */
  ANIMATION("Animation"),

  /** Genre CHILDREN. */
  CHILDREN("Children"),

  /** Genre COMEDY. */
  COMEDY("Comedy"),

  /** Genre CRIME. */
  CRIME("Crime"),

  /** Genre DRAMA. */
  DRAMA("Drama"),

  /** Genre FANTASY. */
  FANTASY("Fantasy"),

  /** Genre HORROR. */
  HORROR("Horror"),

  /** Genre MYSTERY. */
  MYSTERY("Mystery"),

  /** Genre ROMANCE. */
  ROMANCE("Romance"),

  /** Genre SCI_FI. */
  SCI_FI("Sci-Fi"),

  /** Genre THRILLER. */
  THRILLER("Thriller");

  private final String name;

  private Genre(String name) {

    this.name = name;
  }

  /**
   * @return The name of the Genre
   */
  public String getName() {

    return this.name;
  }

}
