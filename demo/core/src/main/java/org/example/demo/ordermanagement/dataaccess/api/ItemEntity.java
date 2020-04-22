package org.example.demo.ordermanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.example.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.common.api.Order;

import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.jpa.dataaccess.api.JpaHelper;

/**
 * {@link ApplicationPersistenceEntity Entity} for {@link Item}.
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity extends ApplicationPersistenceEntity implements Item {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private OrderEntity order;

  private Instant creationDate;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  @Column(name = "PRICE")
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  /**
   * @return the {@link OrderEntity} owning this item.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID")
  public OrderEntity getOrder() {

    return this.order;
  }

  /**
   * @param order new value of {@link #getOrder()}.
   */
  public void setOrder(OrderEntity order) {

    this.order = order;
  }

  @Override
  @Transient
  public IdRef<Order> getOrderId() {

    return IdRef.of(this.order);
  }

  @Override
  public void setOrderId(IdRef<Order> orderId) {

    this.order = JpaHelper.asEntity(orderId, OrderEntity.class);
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
}
