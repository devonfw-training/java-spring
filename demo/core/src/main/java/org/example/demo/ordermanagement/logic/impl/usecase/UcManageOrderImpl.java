package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.general.logic.base.AbstractUc;
import org.example.demo.ordermanagement.dataaccess.api.OrderEntity;
import org.example.demo.ordermanagement.dataaccess.api.repo.OrderRepository;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for modifying and deleting Orders
 */
@Named
@Validated
@Transactional
public class UcManageOrderImpl extends AbstractUc implements UcManageOrder {

  private static final Logger LOG = LoggerFactory.getLogger(UcManageOrderImpl.class);

  /** @see #getOrderRepository() */
  @Inject
  private OrderRepository orderRepository;

  /**
   * Returns the field 'orderRepository'.
   *
   * @return the {@link OrderRepository} instance.
   */
  public OrderRepository getOrderRepository() {

    return this.orderRepository;
  }

  @Override
  public void deleteOrder(Long orderId) {

    if (orderId == null) {
      return;
    }
    OrderEntity order = getOrderRepository().find(orderId);
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
