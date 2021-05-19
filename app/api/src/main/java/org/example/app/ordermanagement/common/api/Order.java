package org.example.app.ordermanagement.common.api;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.app.general.common.api.ApplicationEntity;

/**
 * An {@link Order} is created when a customer starts to order something in the restaurant for the first time. It stays
 * open until it is finally payed by the customer before leaving the restaurant. The {@link Order} contains all
 * {@link Item}s that have been ordered and while open new {@link Item}s can be added.
 */
public interface Order extends ApplicationEntity {

  /**
   * @return the {@link OrderStatus} reflecting the state of this {@link Order} in the process.
   */
  OrderStatus getStatus();

  /**
   * @param status new value of {@link #getStatus()}.
   */
  void setStatus(OrderStatus status);

  /**
   * @return the total price of this {@link Order} what is the summary of all {@link Item#getPrice() item prices}. All
   *         prices are in EURO (€). HINT: To not hardwire the currency one would need to use
   *         {@code javax.money.MonetaryAmount} with lots of additional complexity.
   */
  BigDecimal getPrice();

  /**
   * @param price new value of {@link #getPrice()}.
   */
  void setPrice(BigDecimal price);

  /**
   * @return {@link Instant} when this {@link Order} was initially created.
   */
  Instant getCreationDate();

  /**
   * @param creationDate new value of {@link #getCreationDate()}.
   */
  void setCreationDate(Instant creationDate);

  /**
   * @return {@link Instant} when this {@link Order} was {@link OrderStatus#PAID paid} or {@code null} if not paid.
   */
  Instant getPaymentDate();

  /**
   * @param paymentDate new value of {@link #getPaymentDate()}.
   */
  void setPaymentDate(Instant paymentDate);

}
