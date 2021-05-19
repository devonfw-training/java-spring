package org.example.app.ordermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.example.app.ordermanagement.dataaccess.api.OrderEntity;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.example.app.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.app.ordermanagement.logic.base.usecase.AbstractOrderUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for searching, filtering and getting Orders
 */
@Named
@Validated
@Transactional
public class UcFindOrderImpl extends AbstractOrderUc implements UcFindOrder {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindOrderImpl.class);

  @Override
  public OrderEto findOrder(long id) {

    LOG.debug("Get Order with id {} from database.", id);
    Optional<OrderEntity> foundEntity = getOrderRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), OrderEto.class);
    else
      return null;
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    Page<OrderEntity> orders = getOrderRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(orders, OrderEto.class);
  }

}
