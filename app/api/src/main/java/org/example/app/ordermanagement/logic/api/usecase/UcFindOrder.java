package org.example.app.ordermanagement.logic.api.usecase;

import java.util.List;

import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.springframework.data.domain.Page;

/**
 * Use-case to search and find {@link org.example.app.ordermanagement.common.api.Order}s.
 */
public interface UcFindOrder {

  /**
   * Returns a Order by its id 'id'.
   *
   * @param id The id 'id' of the Order.
   * @return The {@link OrderEto} with id 'id'
   */
  OrderEto findOrder(long id);

  /**
   * Returns a paginated list of Orders matching the search criteria.
   *
   * @param criteria the {@link OrderSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OrderEto}s.
   */
  Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria);

}
