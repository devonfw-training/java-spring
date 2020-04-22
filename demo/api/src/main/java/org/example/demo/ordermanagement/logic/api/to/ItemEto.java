package org.example.demo.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

import org.example.demo.ordermanagement.common.api.Item;

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
  public int hashCode() {

    return Objects.hash(super.hashCode(), this.name, this.price, this.orderId);
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if ((obj == null) || !super.equals(obj)) {
      return false;
    }
    ItemEto other = (ItemEto) obj;
    if (!Objects.equals(this.creationDate, other.creationDate)) {
      return false;
    } else if (!Objects.equals(this.name, other.name)) {
      return false;
    } else if (!Objects.equals(this.price, other.price)) {
      return false;
    } else if (!Objects.equals(this.orderId, other.orderId)) {
      return false;
    }
    return true;
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  public Long getOrderId() {

    return this.orderId;
  }

  @Override
  public void setOrderId(Long orderId) {

    this.orderId = orderId;
  }

  @Override
  public Instant getCreationDate() {

    return this.creationDate;
  }

  @Override
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

}
