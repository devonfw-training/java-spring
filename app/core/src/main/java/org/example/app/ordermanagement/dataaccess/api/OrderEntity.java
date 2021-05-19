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

@Entity
@Table(name = "RESTAURANT_ORDER")
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

  private BigDecimal price;

  private Instant creationData;

  private Instant paymentDate;

  private OrderStatus status;

  @Column(name = "PRICE")
  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Column(name = "CREATION_DATE")
  @Override
  public Instant getCreationData() {

    return this.creationData;
  }

  @Override
  public void setCreationData(Instant creationData) {

    this.creationData = creationData;
  }

  @Column(name = "PAYMENT_DATE")
  @Override
  public Instant getPaymentDate() {

    return this.paymentDate;
  }

  @Override
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  @Override
  public OrderStatus getStatus() {

    return this.status;
  }

  @Override
  public void setStatus(OrderStatus status) {

    this.status = status;
  }

}
