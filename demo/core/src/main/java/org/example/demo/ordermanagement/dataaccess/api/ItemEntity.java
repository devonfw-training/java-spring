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

import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.jpa.dataaccess.api.JpaHelper;

/**
 * {@link ApplicationPersistenceEntity Entity} for Item.
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity extends ApplicationPersistenceEntity {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private OrderEntity order;

  private Instant creationDate;

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  @Column(name = "PRICE")
  public BigDecimal getPrice() {

    return this.price;
  }

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

  @Transient
  public Long getOrderId() {

    if (this.order == null) {
      return null;
    } else {
      return this.order.getId();
    }
  }

  public void setOrderId(Long orderId) {

    this.order = JpaHelper.asEntity(IdRef.of(orderId), OrderEntity.class);
  }

  @Column(name = "CREATION_DATE")
  public Instant getCreationDate() {

    return this.creationDate;
  }

  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
  }
}
