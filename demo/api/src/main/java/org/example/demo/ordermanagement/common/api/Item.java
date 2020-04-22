package org.example.demo.ordermanagement.common.api;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.demo.general.common.api.ApplicationEntity;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * An {@link Item} is a single position of an {@link #getOrderId() Order}. It corresponds to an offer of the restaurant
 * from the menu. Each {@link Item} has a {@link #getPrice() price}, and {@link #getName() name} that represents the
 * values from the {@link Order#getCreationDate() moment} the {@link Item} as ordered. If later in the future the price
 * of an offer is changed in the menu of the restaurant the {@link Order}s and {@link Item}s that have been processed in
 * the past shall not change accordingly as the bills have to be audit-proof.
 */
public interface Item extends ApplicationEntity {

  /**
   * @return the name of this {@link Item} (title of item in the menu).
   */
  public String getName();

  /**
   * @param name new value of {@link #getName()}.
   */
  public void setName(String name);

  /**
   * @return price of this {@link Item} in EURO (€).
   * @see Order#getPrice()
   */
  public BigDecimal getPrice();

  /**
   * @param price new value of {@link #getPrice()}.
   */
  public void setPrice(BigDecimal price);

  /**
   * @return {@link IdRef} to the {@link Order} owining this {@link Item}.
   */
  public IdRef<Order> getOrderId();

  /**
   * @param orderId new value of {@link #getOrderId()}.
   */
  public void setOrderId(IdRef<Order> orderId);

  /**
   * @return {@link Instant} when this {@link Item} was created (and added to {@link Order}).
   */
  Instant getCreationDate();

  /**
   * @param creationDate new value of {@link #getCreationDate()}.
   */
  void setCreationDate(Instant creationDate);

}
