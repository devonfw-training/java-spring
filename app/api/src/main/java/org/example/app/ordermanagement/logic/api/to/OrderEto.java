package org.example.app.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.app.ordermanagement.common.api.Order;
import org.example.app.ordermanagement.common.api.OrderStatus;

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

    return price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  public Instant getCreationDate() {

    return creationDate;
  }

  @Override
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

  @Override
  public Instant getPaymentDate() {

    return paymentDate;
  }

  @Override
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Override
  public OrderStatus getStatus() {

    return status;
  }

  @Override
  public void setStatus(OrderStatus status) {

    this.status = status;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    result = prime * result + ((this.creationDate == null) ? 0 : this.creationDate.hashCode());
    result = prime * result + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());
    result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    OrderEto other = (OrderEto) obj;
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    if (this.creationDate == null) {
      if (other.creationDate != null) {
        return false;
      }
    } else if (!this.creationDate.equals(other.creationDate)) {
      return false;
    }
    if (this.paymentDate == null) {
      if (other.paymentDate != null) {
        return false;
      }
    } else if (!this.paymentDate.equals(other.paymentDate)) {
      return false;
    }
    if (this.status == null) {
      if (other.status != null) {
        return false;
      }
    } else if (!this.status.equals(other.status)) {
      return false;
    }
    return true;
  }

}
