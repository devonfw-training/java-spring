package org.example.app.moviemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.app.moviemanagement.logic.api.Moviemanagement;
import org.example.app.moviemanagement.logic.api.to.MovieEto;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.springframework.data.domain.Page;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Moviemanagement}.
 */
@Path("/moviemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MoviemanagementRestService {

  /**
   * Delegates to {@link Moviemanagement#findMovie}.
   *
   * @param id the ID of the {@link MovieEto}
   * @return the {@link MovieEto}
   */
  @GET
  @Path("/movie/{id}/")
  public MovieEto getMovie(@PathParam("id") long id);

  /**
   * Delegates to {@link Moviemanagement#saveMovie}.
   *
   * @param movie the {@link MovieEto} to be saved
   * @return the recently created {@link MovieEto}
   */
  @POST
  @Path("/movie/")
  public MovieEto saveMovie(MovieEto movie);

  /**
   * Delegates to {@link Moviemanagement#deleteMovie}.
   *
   * @param id ID of the {@link MovieEto} to be deleted
   */
  @DELETE
  @Path("/movie/{id}/")
  public void deleteMovie(@PathParam("id") long id);

  /**
   * Delegates to {@link Moviemanagement#findMovieEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding movies.
   * @return the {@link Page list} of matching {@link MovieEto}s.
   */
  @Path("/movie/search")
  @POST
  public Page<MovieEto> findMovies(MovieSearchCriteriaTo searchCriteriaTo);

}
