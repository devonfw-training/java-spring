package org.example.app.ordermanagement.common.api;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.app.ordermanagement.dataaccess.api.OrderEntity;

/**
 * The Item of an Order.
 */
public interface Item {

  /**
   * @param creationDate
   */
  void setCreationDate(Instant creationDate);

  /**
   * @return creationDate
   */
  Instant getCreationDate();

  /**
   * @param order
   */
  void setOrder(OrderEntity order);

  /**
   * @return order
   */
  OrderEntity getOrder();

  /**
   * @param price
   */
  void setPrice(BigDecimal price);

  /**
   * @return price
   */
  BigDecimal getPrice();

  /**
   * @param name
   */
  void setName(String name);

  /**
   * @return name
   */
  String getName();

}
