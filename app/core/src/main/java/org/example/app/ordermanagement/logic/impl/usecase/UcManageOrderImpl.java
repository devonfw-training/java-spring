package org.example.app.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.ordermanagement.dataaccess.api.OrderEntity;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.usecase.UcManageOrder;
import org.example.app.ordermanagement.logic.base.usecase.AbstractOrderUc;
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
public class UcManageOrderImpl extends AbstractOrderUc implements UcManageOrder {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageOrderImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_ORDER)
  public boolean deleteOrder(long orderId) {

    OrderEntity order = getOrderRepository().find(orderId);
    getOrderRepository().delete(order);
    LOG.debug("The order with id '{}' has been deleted.", orderId);
    return true;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_ORDER)
  public OrderEto saveOrder(OrderEto order) {

    Objects.requireNonNull(order, "order");

    OrderEntity orderEntity = getBeanMapper().map(order, OrderEntity.class);

    // initialize, validate orderEntity here if necessary
    OrderEntity resultEntity = getOrderRepository().save(orderEntity);
    LOG.debug("Order with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, OrderEto.class);
  }

}
