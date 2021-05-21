package org.example.app.ordermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.example.app.ordermanagement.logic.api.Ordermanagement;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.springframework.data.domain.Page;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Path("/ordermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OrdermanagementRestService {

  /**
   * Delegates to {@link Ordermanagement#findOrder}.
   *
   * @param id the ID of the {@link OrderEto}
   * @return the {@link OrderEto}
   */
  @GET
  @Path("/order/{id}/")
  public OrderEto getOrder(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#saveOrder}.
   *
   * @param order the {@link OrderEto} to be saved
   * @return the recently created {@link OrderEto}
   */
  @POST
  @Path("/order/")
  public OrderEto saveOrder(OrderEto order);

  /**
   * Delegates to {@link Ordermanagement#deleteOrder}.
   *
   * @param id ID of the {@link OrderEto} to be deleted
   */
  @DELETE
  @Path("/order/{id}/")
  public void deleteOrder(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#findOrderEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding orders.
   * @return the {@link Page list} of matching {@link OrderEto}s.
   */
  @Path("/order/search")
  @POST
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Ordermanagement#findItem}.
   *
   * @param id the ID of the {@link ItemEto}
   * @return the {@link ItemEto}
   */
  @GET
  @Path("/item/{id}/")
  public ItemEto getItem(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#saveItem}.
   *
   * @param item the {@link ItemEto} to be saved
   * @return the recently created {@link ItemEto}
   */
  @POST
  @Path("/item/")
  public ItemEto saveItem(ItemEto item);

  /**
   * Delegates to {@link Ordermanagement#deleteItem}.
   *
   * @param id ID of the {@link ItemEto} to be deleted
   */
  @DELETE
  @Path("/item/{id}/")
  public void deleteItem(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#findItemEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding items.
   * @return the {@link Page list} of matching {@link ItemEto}s.
   */
  @Path("/item/search")
  @POST
  public Page<ItemEto> findItems(ItemSearchCriteriaTo searchCriteriaTo);

}
