package org.example.app.ordermanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.example.app.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.app.ordermanagement.common.api.Order;
import org.example.app.ordermanagement.common.api.OrderStatus;

/**
 * {@link ApplicationPersistenceEntity Entity} for {@link Order}.
 */
@Entity
@Table(name = "RESTAURANT_ORDER")
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

  private BigDecimal price;

  private Instant creationDate;

  private Instant paymentDate;

  private OrderStatus status;

  private static final long serialVersionUID = 1L;

  @Override
  @Column(name = "PRICE")
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  @Column(name = "CREATION_DATE")
  public Instant getCreationDate() {

    return this.creationDate;
  }

  @Override
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

  @Override
  @Column(name = "PAYMENT_DATE")
  public Instant getPaymentDate() {

    return this.paymentDate;
  }

  @Override
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Override
  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  public OrderStatus getStatus() {

    return this.status;
  }

  @Override
  public void setStatus(OrderStatus status) {

    this.status = status;
  }

}
