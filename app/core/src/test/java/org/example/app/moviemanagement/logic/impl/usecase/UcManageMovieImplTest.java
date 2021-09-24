package org.example.app.moviemanagement.logic.impl.usecase;

import java.util.Arrays;

import javax.inject.Inject;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.general.common.base.test.ApplicationComponentTest;
import org.example.app.general.common.base.test.TestUtil;
import org.example.app.moviemanagement.common.api.Genre;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.IndicativeSentences;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.AccessDeniedException;

@DisplayNameGeneration(IndicativeSentences.class)
class UcManageMovieImplTest extends ApplicationComponentTest {

  private static final String TEST_USER = "TestUser";

  @Inject
  UcManageMovieImpl cut;

  @Inject
  UcFindMovieImpl findMovieUseCase;

  @Nested
  @DisplayName("SaveMovie")
  @IndicativeSentencesGeneration(generator = ReplaceUnderscores.class, separator = " › ")
  class SaveMovie {

    @Test
    void requires_specific_permission() {

      TestUtil.login(TEST_USER);
      assertThatThrownBy(() -> UcManageMovieImplTest.this.cut.saveMovie(null))
          .isInstanceOf(AccessDeniedException.class);
    }

    @BeforeEach
    void loginAsAuthorizedUser() {

      TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_SAVE_MOVIE);
    }

    @Nested
    class When_movie_exists {

      @Test
      void should_update_data_if_valid() {

        MovieEto updatedMovie = new MovieEto();
        updatedMovie.setId(1L);
        updatedMovie.setTitle("Toy Story - updated title");
        updatedMovie.setYear(1995);

        MovieEto returnValue = UcManageMovieImplTest.this.cut.saveMovie(updatedMovie);

        assertThat(returnValue) //
            .usingRecursiveComparison() //
            .ignoringFields("id", "persistentEntity", "modificationCounter") //
            .isEqualTo(updatedMovie);
      }

      @Test
      void should_track_modifications() {

        MovieEto updatedMovie = new MovieEto();
        updatedMovie.setId(1L);
        updatedMovie.setTitle("Toy Story - updated title");
        updatedMovie.setYear(1995);

        MovieEto returnValue = UcManageMovieImplTest.this.cut.saveMovie(updatedMovie);

        assertThat(returnValue.getModificationCounter()).isEqualTo(1);
      }

      @Test
      void should_allow_replacing_genre_associations() {

        TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_SAVE_MOVIE,
            ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE);

        MovieEto updatedMovie = UcManageMovieImplTest.this.findMovieUseCase.findMovie(1L);
        updatedMovie.setGenres(Arrays.asList(Genre.ROMANCE));

        MovieEto returnValue = UcManageMovieImplTest.this.cut.saveMovie(updatedMovie);

        assertThat(returnValue.getGenres()).containsExactly(Genre.ROMANCE);
      }
    }

    @Nested
    class When_new_movie {

      MovieEto newMovie;

      @BeforeEach
      void initializeNewMovie() {

        this.newMovie = new MovieEto();
        this.newMovie.setTitle("The Matrix");
        this.newMovie.setYear(1997);
        this.newMovie.setGenres(Arrays.asList(Genre.SCI_FI, Genre.ACTION));

      }

      @Test
      void should_save_if_valid() {

        MovieEto returnValue = UcManageMovieImplTest.this.cut.saveMovie(this.newMovie);

        assertThat(returnValue) //
            .usingRecursiveComparison() //
            .ignoringFields("id", "persistentEntity") //
            .isEqualTo(this.newMovie);
        assertThat(returnValue.getId()).isNotNull();
      }

      @Test
      void should_be_findable() {

        TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_SAVE_MOVIE,
            ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE);

        MovieEto returnValue = UcManageMovieImplTest.this.cut.saveMovie(this.newMovie);

        assertThat(UcManageMovieImplTest.this.findMovieUseCase.findMovie(returnValue.getId())).isNotNull();
      }

      @Test
      void should_fail_if_title_is_blank() {

        this.newMovie.setTitle("");

        UcManageMovieImplTest.this.cut.saveMovie(this.newMovie);
      }

      @Test
      void should_fail_if_year_is_missing() {

        this.newMovie.setYear(null);

        UcManageMovieImplTest.this.cut.saveMovie(this.newMovie);
      }

      @Test
      void should_fail_if_same_title_and_year_exist() {

        this.newMovie = new MovieEto();
        this.newMovie.setTitle("Toy Story");
        this.newMovie.setYear(1995);

        assertThatThrownBy(() -> UcManageMovieImplTest.this.cut.saveMovie(this.newMovie))
            .isInstanceOf(DataIntegrityViolationException.class);
      }
    }

  }

  @Nested
  @DisplayName("DeleteMovie")
  @IndicativeSentencesGeneration(generator = ReplaceUnderscores.class, separator = " › ")
  class DeleteMovie {

    @Test
    void requires_specific_permission() {

      TestUtil.login(TEST_USER);
      assertThatThrownBy(() -> UcManageMovieImplTest.this.cut.deleteMovie(0)).isInstanceOf(AccessDeniedException.class);
    }

    @BeforeEach
    void loginAsAuthorizedUser() {

      TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_DELETE_MOVIE);
    }

    @Nested
    class When_movie_exists {

      @Test
      void should_succeed() {

        UcManageMovieImplTest.this.cut.deleteMovie(1);
      }

      @Test
      void should_not_be_findable_afterwards() {

        TestUtil.login(TEST_USER, ApplicationAccessControlConfig.PERMISSION_DELETE_MOVIE,
            ApplicationAccessControlConfig.PERMISSION_FIND_MOVIE);

        assertThat(UcManageMovieImplTest.this.findMovieUseCase.findMovie(1L)).isNotNull();

        UcManageMovieImplTest.this.cut.deleteMovie(1L);

        assertThat(UcManageMovieImplTest.this.findMovieUseCase.findMovie(1L)).isNull();
      }
    }

    @Nested
    class When_movie_does_not_exist {

      @Test
      void should_fail() {

        assertThatThrownBy(() -> UcManageMovieImplTest.this.cut.deleteMovie(-1L)).isInstanceOf(RuntimeException.class);
      }
    }
  }
}
