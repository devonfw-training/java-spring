package org.example.app.ordermanagement.common.api;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * An Order.
 */
public interface Order {

  /**
   * @return price
   */
  BigDecimal getPrice();

  /**
   * @param price new value of {@link #getprice}.
   */
  void setPrice(BigDecimal price);

  /**
   * @return creationData
   */
  Instant getCreationData();

  /**
   * @param creationData new value of {@link #getcreationData}.
   */
  void setCreationData(Instant creationData);

  /**
   * @return paymentDate
   */
  Instant getPaymentDate();

  /**
   * @param paymentDate new value of {@link #getpaymentDate}.
   */
  void setPaymentDate(Instant paymentDate);

  /**
   * @return
   */
  OrderStatus getStatus();

  /**
   * @param status
   */
  void setStatus(OrderStatus status);

}