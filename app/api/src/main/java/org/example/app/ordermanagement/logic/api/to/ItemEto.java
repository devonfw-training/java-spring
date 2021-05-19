package org.example.app.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.app.ordermanagement.common.api.Item;

import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Item
 */
public class ItemEto extends AbstractEto implements Item {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private Long orderId;

  private Instant creationDate;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public BigDecimal getPrice() {

    return price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  public Long getOrderId() {

    return orderId;
  }

  @Override
  public void setOrderId(Long orderId) {

    this.orderId = orderId;
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
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());

    result = prime * result + ((this.orderId == null) ? 0 : this.orderId.hashCode());
    result = prime * result + ((this.creationDate == null) ? 0 : this.creationDate.hashCode());
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
    ItemEto other = (ItemEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }

    if (this.orderId == null) {
      if (other.orderId != null) {
        return false;
      }
    } else if (!this.orderId.equals(other.orderId)) {
      return false;
    }
    if (this.creationDate == null) {
      if (other.creationDate != null) {
        return false;
      }
    } else if (!this.creationDate.equals(other.creationDate)) {
      return false;
    }
    return true;
  }
}
