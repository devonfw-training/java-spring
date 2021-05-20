package org.example.app.ordermanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.example.app.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.app.ordermanagement.common.api.OrderStatus;

/**
 * {@link ApplicationPersistenceEntity Entity} for {@link Order}.
 */
@Entity
@Table(name = "RESTAURANT_ORDER")
public class OrderEntity extends ApplicationPersistenceEntity {

  private BigDecimal price;

  private Instant creationDate;

  private Instant paymentDate;

  private OrderStatus status;

  private static final long serialVersionUID = 1L;

  @Column(name = "PRICE")
  public BigDecimal getPrice() {

    return this.price;
  }

  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Column(name = "CREATION_DATE")
  public Instant getCreationDate() {

    return this.creationDate;
  }

  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

  @Column(name = "PAYMENT_DATE")
  public Instant getPaymentDate() {

    return this.paymentDate;
  }

  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  public OrderStatus getStatus() {

    return this.status;
  }

  public void setStatus(OrderStatus status) {

    this.status = status;
  }

}