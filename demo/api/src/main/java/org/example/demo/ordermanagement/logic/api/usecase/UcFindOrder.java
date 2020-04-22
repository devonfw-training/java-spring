package org.example.demo.ordermanagement.logic.api.usecase;

import java.util.List;

import org.example.demo.ordermanagement.common.api.Order;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.springframework.data.domain.Page;

/**
 * Use-case to search and find {@link Order}s.
 */
public interface UcFindOrder {

  /**
   * @param id {@link OrderEto#getId() primary key} of {@link Order} to find.
   * @return the {@link OrderEto} with the given ID or {@code null} if not found.
   */
  OrderEto findOrder(Long id);

  /**
   * @param criteria the {@link OrderSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OrderEto}s.
   */
  Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria);

}
