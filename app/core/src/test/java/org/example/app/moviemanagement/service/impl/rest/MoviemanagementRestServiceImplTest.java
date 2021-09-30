package org.example.app.moviemanagement.service.impl.rest;

import java.util.Arrays;

import org.example.app.general.service.base.test.RestServiceTest;
import org.example.app.moviemanagement.common.api.Genre;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.example.app.moviemanagement.service.api.rest.MoviemanagementRestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;

import com.devonfw.module.service.common.api.client.config.ServiceClientConfigBuilder;

class MoviemanagementRestServiceImplTest extends RestServiceTest {

  private MoviemanagementRestService cut;

  @BeforeEach
  void createServiceInterface() {

    this.cut = createServiceInterfaceWithAuth(MoviemanagementRestService.class);
  }

  @Test
  void findMovies() {

    MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
    searchCriteria.setTitle("Toy Story");
    Page<MovieEto> returnValue = this.cut.findMovies(searchCriteria);

    assertThat(returnValue.getTotalElements()).isEqualTo(1);
    assertThat(returnValue.getContent()) //
        .hasSize(1) //
        .extracting(MovieEto::getId) //
        .containsExactly(1L);
  }

  @Test
  void saveMovie() {

    MovieEto newMovie = new MovieEto();
    newMovie.setTitle("The Matrix");
    newMovie.setYear(1997);
    newMovie.setGenres(Arrays.asList(Genre.ACTION, Genre.SCI_FI));

    MovieEto savedMovie = this.cut.saveMovie(newMovie);

    assertThat(savedMovie.getId()).isNotNull();
  }

  @Test
  void deleteMovie() {

    assertMovieWithTitleExists("Toy Story");
    this.cut.deleteMovie(1L);
    assertNoMovieWithTitleExists("Toy Story");
  }

  private void assertMovieWithTitleExists(String movieTitle) {

    MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
    searchCriteria.setTitle(movieTitle);
    Page<MovieEto> returnValue = this.cut.findMovies(searchCriteria);

    assertThat(returnValue.getTotalElements()).isEqualTo(1);
  }

  private void assertNoMovieWithTitleExists(String movieTitle) {

    MovieSearchCriteriaTo searchCriteria = new MovieSearchCriteriaTo();
    searchCriteria.setTitle(movieTitle);
    Page<MovieEto> returnValue = this.cut.findMovies(searchCriteria);

    assertThat(returnValue.getTotalElements()).isEqualTo(0);
  }

  private <T> T createServiceInterfaceWithAuth(Class<T> serviceInterface) {

    return getServiceClientFactory().create(serviceInterface, new ServiceClientConfigBuilder().host("localhost")
        .authBasic().userLogin("admin").userPassword("admin").buildMap());
  }
}
