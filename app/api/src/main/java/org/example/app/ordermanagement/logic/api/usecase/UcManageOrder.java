package org.example.app.ordermanagement.logic.api.usecase;

import org.example.app.ordermanagement.logic.api.to.OrderEto;

/**
 * Use-case to manage and modify {@link org.example.app.ordermanagement.common.api.Order}s.
 */
public interface UcManageOrder {

  /**
   * Deletes a order from the database by its id 'orderId'.
   *
   * @param orderId Id of the order to delete
   * @return boolean <code>true</code> if the order can be deleted, <code>false</code> otherwise
   */
  boolean deleteOrder(long orderId);

  /**
   * Saves a order and store it in the database.
   *
   * @param order the {@link OrderEto} to create.
   * @return the new {@link OrderEto} that has been saved with ID and version.
   */
  OrderEto saveOrder(OrderEto order);

}
