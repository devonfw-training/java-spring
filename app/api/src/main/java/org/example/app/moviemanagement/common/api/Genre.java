package org.example.app.moviemanagement.common.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * List of movie genres
 */
public class Genre {
  /** Das Separator-Zeichen um Genres zu trennen. */
  public static final char SEPARATOR = '|';

  /** Genre {@value}. */
  public static final String GENRE_ACTION = "Action";

  /** Genre {@value}. */
  public static final String GENRE_ADVENTURE = "Adventure";

  /** Genre {@value}. */
  public static final String GENRE_ANIMATION = "Animation";

  /** Genre {@value}. */
  public static final String GENRE_CHILDREN = "Children";

  /** Genre {@value}. */
  public static final String GENRE_COMEDY = "Comedy";

  /** Genre {@value}. */
  public static final String GENRE_CRIME = "Crime";

  /** Genre {@value}. */
  public static final String GENRE_DRAMA = "Drama";

  /** Genre {@value}. */
  public static final String GENRE_FANTASY = "Fantasy";

  /** Genre {@value}. */
  public static final String GENRE_HORROR = "Horror";

  /** Genre {@value}. */
  public static final String GENRE_MYSTERY = "Mystery";

  /** Genre {@value}. */
  public static final String GENRE_ROMANCE = "Romance";

  /** Genre {@value}. */
  public static final String GENRE_SCI_FI = "Sci-Fi";

  /** Genre {@value}. */
  public static final String GENRE_THRILLER = "Thriller";

  /**
   * Die {@link List}e aller {@link Genre}s.
   */
  public static final List<String> GENRES = Collections.unmodifiableList(
      Arrays.asList(GENRE_ACTION, GENRE_ADVENTURE, GENRE_ANIMATION, GENRE_CHILDREN, GENRE_COMEDY, GENRE_CRIME,
          GENRE_DRAMA, GENRE_FANTASY, GENRE_HORROR, GENRE_MYSTERY, GENRE_ROMANCE, GENRE_SCI_FI, GENRE_THRILLER));

  private Genre() {

  }

}
