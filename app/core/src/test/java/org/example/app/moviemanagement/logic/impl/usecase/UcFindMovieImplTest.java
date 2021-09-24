package org.example.app.moviemanagement.logic.impl.usecase;

import javax.inject.Inject;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.general.common.base.test.ApplicationComponentTest;
import org.example.app.general.common.base.test.TestUtil;
import org.example.app.moviemanagement.common.api.Genre;
import org.example.app.moviemanagement.logic.api.to.Assertions;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;

import com.devonfw.module.basic.common.api.query.LikePatternSyntax;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;
import com.devonfw.module.basic.common.api.query.StringSearchOperator;

class UcFindMovieImplTest extends ApplicationComponentTest {

  private static final String TEST_USER = "TestUser";

  @Inject
  UcFindMovieImpl cut;

  @Nested
  @DisplayName("FindMovie")
  @IndicativeSentencesGeneration(generator = ReplaceUnderscores.class, separator = " › ")
  class FindMovie {

    @Test
    void requires_specific_permission() {

      TestUtil.login(TEST_USER);
      assertThatThrownBy(() -> UcFindMovieImplTest.this.cut.findMovie(1L)).isInstanceOf(AccessDeniedException.class);
    }

    @BeforeEach
    void loginAsAuthorizedUser() {

      TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE);
    }

    @Nested
    class When_movie_with_id_exists {

      @Test
      void should_return_non_null_entity() {

        assertThat(UcFindMovieImplTest.this.cut.findMovie(1L)).isNotNull();
      }

      @Test
      void should_return_fully_loaded_entity() {

        Assertions.assertThat(UcFindMovieImplTest.this.cut.findMovie(1L)) //
            .hasTitle("Toy Story") //
            .hasYear(1995) //
            .hasOnlyGenres(Genre.ADVENTURE, Genre.ANIMATION, Genre.CHILDREN, Genre.COMEDY, Genre.FANTASY);
      }
    }

    @Nested
    class When_movie_not_found {

      @Test
      void should_return_null() {

        assertThat(UcFindMovieImplTest.this.cut.findMovie(-1)).isNull();
      }
    }
  }

  @Nested
  @DisplayName("FindMovies")
  @IndicativeSentencesGeneration(generator = ReplaceUnderscores.class, separator = " › ")
  class FindMovies {

    @Test
    void requires_specific_permission() {

      TestUtil.login(TEST_USER);
      assertThatThrownBy(() -> UcFindMovieImplTest.this.cut.findMovies(null)).isInstanceOf(AccessDeniedException.class);
    }

    @BeforeEach
    void loginAsAuthorizedUser() {

      TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE);
    }

    @Nested
    class When_searching_by_title {

      @Test
      void should_allow_exact_matching() {

        MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
        searchCriteria.setTitle("Toy Story");
        searchCriteria.setTitleOption(StringSearchConfigTo.of(StringSearchOperator.EQ));

        Page<MovieEto> searchResult = UcFindMovieImplTest.this.cut.findMovies(searchCriteria);

        assertThat(searchResult.getTotalElements()).isEqualTo(1);
        Assertions.assertThat(searchResult.getContent().get(0)).hasTitle("Toy Story");
      }

      @Test
      void should_allow_substring_searches() {

        MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
        searchCriteria.setTitle("*Mo*");
        searchCriteria.setTitleOption(StringSearchConfigTo.of(LikePatternSyntax.GLOB));

        Page<MovieEto> searchResult = UcFindMovieImplTest.this.cut.findMovies(searchCriteria);

        assertThat(searchResult.getTotalElements()).isEqualTo(2);
        assertThat(searchResult.getContent()).extracting(MovieEto::getTitle)
            .containsExactlyInAnyOrder("Twelve Monkeys (a.k.a. 12 Monkeys)", "Mortal Kombat");
      }
    }

    @Nested
    class When_searching_by_genres {

      // TODO: Add tests for genre search

    }

    @Nested
    class When_searching_by_year {

      @Test
      void should_allow_exact_matching() {

        MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
        searchCriteria.setYear(1995);

        Page<MovieEto> searchResult = UcFindMovieImplTest.this.cut.findMovies(searchCriteria);

        assertThat(searchResult.getTotalElements()).isGreaterThan(0);
        assertThat(searchResult.getContent()).extracting(MovieEto::getYear).allMatch(v -> v == 1995);
      }

      @Test
      void should_return_empty_list_if_none_are_found() {

        MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
        searchCriteria.setYear(1776);

        Page<MovieEto> searchResult = UcFindMovieImplTest.this.cut.findMovies(searchCriteria);

        assertThat(searchResult.getTotalElements()).isEqualTo(0);
        assertThat(searchResult.getContent()).isEmpty();
      }
    }
  }
}
