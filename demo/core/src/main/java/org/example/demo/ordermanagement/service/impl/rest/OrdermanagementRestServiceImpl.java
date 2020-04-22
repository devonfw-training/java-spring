package org.example.demo.ordermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ordermanagement.logic.api.Ordermanagement;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.example.demo.ordermanagement.service.api.rest.OrdermanagementRestService;
import org.springframework.data.domain.Page;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Named("OrdermanagementRestService")
public class OrdermanagementRestServiceImpl implements OrdermanagementRestService {

  @Inject
  private Ordermanagement ordermanagement;

  @Override
  public OrderEto findOrder(long id) {

    return this.ordermanagement.findOrder(IdRef.of(id));
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ordermanagement.saveOrder(order);
  }

  @Override
  public void deleteOrder(long id) {

    this.ordermanagement.deleteOrder(IdRef.of(id));
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findOrders(searchCriteriaTo);
  }

  @Override
  public ItemEto findItem(long id) {

    return this.ordermanagement.findItem(IdRef.of(id));
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    return this.ordermanagement.saveItem(item);
  }

  @Override
  public void deleteItem(long id) {

    this.ordermanagement.deleteItem(IdRef.of(id));
  }

  @Override
  public Page<ItemEto> findItems(ItemSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findItems(searchCriteriaTo);
  }

}
