package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.general.logic.base.AbstractUc;
import org.example.demo.ordermanagement.dataaccess.api.OrderEntity;
import org.example.demo.ordermanagement.dataaccess.api.repo.OrderRepository;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Implementation of {@link UcFindOrder}.
 */
@Named
@Validated
@Transactional
public class UcFindOrderImpl extends AbstractUc implements UcFindOrder {

  private static final Logger LOG = LoggerFactory.getLogger(UcFindOrderImpl.class);

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
  public OrderEto findOrder(Long id) {

    if (id != null) {
      LOG.debug("Get Order with id {} from database.", id);
      Optional<OrderEntity> foundEntity = getOrderRepository().findById(id);
      if (foundEntity.isPresent()) {
        return getBeanMapper().map(foundEntity.get(), OrderEto.class);
      }
    }
    return null;
  }

}
