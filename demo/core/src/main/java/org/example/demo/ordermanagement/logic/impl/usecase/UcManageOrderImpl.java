package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.example.demo.ordermanagement.common.api.Order;
import org.example.demo.ordermanagement.dataaccess.api.OrderEntity;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageOrder;
import org.example.demo.ordermanagement.logic.base.usecase.AbstractOrderUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for modifying and deleting Orders
 */
@Named
@Validated
@Transactional
public class UcManageOrderImpl extends AbstractOrderUc implements UcManageOrder {

  private static final Logger LOG = LoggerFactory.getLogger(UcManageOrderImpl.class);

  @Override
  public void deleteOrder(IdRef<Order> orderId) {

    if (orderId == null) {
      return;
    }
    OrderEntity order = getOrderRepository().find(orderId.getId());
    getOrderRepository().delete(order);
    LOG.debug("The order with id '{}' has been deleted.", orderId);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    Objects.requireNonNull(order, "order");

    OrderEntity orderEntity = getBeanMapper().map(order, OrderEntity.class);

    // initialize, validate orderEntity here if necessary
    OrderEntity resultEntity = getOrderRepository().save(orderEntity);
    LOG.debug("Order with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, OrderEto.class);
  }
}
