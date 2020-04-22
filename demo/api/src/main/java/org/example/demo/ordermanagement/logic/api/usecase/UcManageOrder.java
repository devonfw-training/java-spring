package org.example.demo.ordermanagement.logic.api.usecase;

import org.example.demo.ordermanagement.common.api.Order;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use-case for standard write operations (create/update/delete) of {@link Order}s.
 */
public interface UcManageOrder {

  /**
   * @param orderId {@link IdRef} of {@link Order} to delete.
   */
  void deleteOrder(IdRef<Order> orderId);

  /**
   * @param order the {@link OrderEto} to create or update.
   * @return the {@link OrderEto} that has been saved with {@link OrderEto#getId() ID} and
   *         {@link OrderEto#getModificationCounter() modification counter}.
   */
  OrderEto saveOrder(OrderEto order);

}
