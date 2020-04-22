package org.example.demo.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import org.example.demo.ordermanagement.common.api.Order;
import org.example.demo.ordermanagement.common.api.OrderStatus;

import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Order
 */
public class OrderEto extends AbstractEto implements Order {

  private static final long serialVersionUID = 1L;

  private BigDecimal price;

  private Instant creationDate;

  private Instant paymentDate;

  private OrderStatus status;

  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  public Instant getCreationDate() {

    return this.creationDate;
  }

  @Override
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

  @Override
  public Instant getPaymentDate() {

    return this.paymentDate;
  }

  @Override
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Override
  public OrderStatus getStatus() {

    return this.status;
  }

  @Override
  public void setStatus(OrderStatus status) {

    this.status = status;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), this.creationDate);
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if ((obj == null) || !super.equals(obj)) {
      return false;
    }
    OrderEto other = (OrderEto) obj;
    if (!Objects.equals(this.price, other.price)) {
      return false;
    } else if (!Objects.equals(this.creationDate, other.creationDate)) {
      return false;
    } else if (!Objects.equals(this.paymentDate, other.paymentDate)) {
      return false;
    } else if (!Objects.equals(this.price, other.price)) {
      return false;
    } else if (!Objects.equals(this.status, other.status)) {
      return false;
    }
    return true;
  }
}
