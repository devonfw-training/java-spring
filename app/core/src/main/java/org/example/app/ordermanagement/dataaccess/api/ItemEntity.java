package org.example.app.ordermanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.example.app.general.dataaccess.api.ApplicationPersistenceEntity;
import org.example.app.ordermanagement.common.api.Item;

import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.jpa.dataaccess.api.JpaHelper;

/**
 * {@link ApplicationPersistenceEntity Entity} for {@link Item}.
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity extends ApplicationPersistenceEntity implements Item {

  private String name;

  private BigDecimal price;

  private OrderEntity order;

  private Instant creationDate;

  private static final long serialVersionUID = 1L;

  @Override
  @Column(name = "NAME")
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

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID")
  public OrderEntity getOrder() {

    return this.order;
  }

  public void setOrder(OrderEntity order) {

    this.order = order;
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
  @Transient
  public Long getOrderId() {

    if (this.order == null) {
      return null;
    } else {
      return this.order.getId();
    }
  }

  @Override
  public void setOrderId(Long orderId) {

    this.order = JpaHelper.asEntity(IdRef.of(orderId), OrderEntity.class);
  }

}
