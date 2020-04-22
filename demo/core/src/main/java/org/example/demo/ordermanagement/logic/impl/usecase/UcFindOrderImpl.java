package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.example.demo.ordermanagement.common.api.Order;
import org.example.demo.ordermanagement.dataaccess.api.OrderEntity;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.demo.ordermanagement.logic.base.usecase.AbstractOrderUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Implementation of {@link UcFindOrder}.
 */
@Named
@Validated
@Transactional
public class UcFindOrderImpl extends AbstractOrderUc implements UcFindOrder {

  private static final Logger LOG = LoggerFactory.getLogger(UcFindOrderImpl.class);

  @Override
  public OrderEto findOrder(IdRef<Order> id) {

    Long orderId = null;
    if (id != null) {
      orderId = id.getId();
    }
    if (orderId != null) {
      LOG.debug("Get Order with id {} from database.", orderId);
      Optional<OrderEntity> foundEntity = getOrderRepository().findById(orderId);
      if (foundEntity.isPresent()) {
        return getBeanMapper().map(foundEntity.get(), OrderEto.class);
      }
    }
    return null;
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    Page<OrderEntity> orders = getOrderRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(orders, OrderEto.class);
  }

}
