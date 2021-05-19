package org.example.app.ordermanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.example.app.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.app.ordermanagement.common.api.Item;

@Entity
@Table(name = "ITEM")
public class ItemEntity extends ApplicationPersistenceEntity implements Item {

  private String name;

  private BigDecimal price;

  private OrderEntity order;

  private Instant creationDate;

  @Column(name = "NAME")
  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Column(name = "PRICE")
  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID")
  @Override
  public OrderEntity getOrder() {

    return this.order;
  }

  @Override
  public void setOrder(OrderEntity order) {

    this.order = order;
  }

  @Column(name = "CREATION_DATE")
  @Override
  public Instant getCreationDate() {

    return this.creationDate;
  }

  @Override
  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }

}
