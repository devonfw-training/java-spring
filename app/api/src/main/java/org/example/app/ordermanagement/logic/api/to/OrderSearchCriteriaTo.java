package org.example.app.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.app.general.common.api.to.AbstractSearchCriteriaTo;
import org.example.app.ordermanagement.common.api.OrderStatus;

/**
 * {@link SearchCriteriaTo} to find instances of {@link org.example.app.ordermanagement.common.api.Order}s.
 */
public class OrderSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private BigDecimal price;

  private Instant creationDate;

  private Instant paymentDate;

  private OrderStatus status;

  /**
   * @return priceId
   */
  public BigDecimal getPrice() {

    return price;
  }

  /**
   * @param price setter for price attribute
   */
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  /**
   * @return creationDateId
   */
  public Instant getCreationDate() {

    return creationDate;
  }

  /**
   * @param creationDate setter for creationDate attribute
   */
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

  /**
   * @return paymentDateId
   */
  public Instant getPaymentDate() {

    return paymentDate;
  }

  /**
   * @param paymentDate setter for paymentDate attribute
   */
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  /**
   * @return statusId
   */
  public OrderStatus getStatus() {

    return status;
  }

  /**
   * @param status setter for status attribute
   */
  public void setStatus(OrderStatus status) {

    this.status = status;
  }

}
