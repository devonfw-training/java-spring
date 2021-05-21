package org.example.app.ordermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.app.ordermanagement.logic.api.Ordermanagement;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.example.app.ordermanagement.service.api.rest.OrdermanagementRestService;
import org.springframework.data.domain.Page;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Named("OrdermanagementRestService")
public class OrdermanagementRestServiceImpl implements OrdermanagementRestService {

  @Inject
  private Ordermanagement ordermanagement;

  @Override
  public OrderEto getOrder(long id) {

    return this.ordermanagement.findOrder(id);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ordermanagement.saveOrder(order);
  }

  @Override
  public void deleteOrder(long id) {

    this.ordermanagement.deleteOrder(id);
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findOrders(searchCriteriaTo);
  }

  @Override
  public ItemEto getItem(long id) {

    return this.ordermanagement.findItem(id);
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    return this.ordermanagement.saveItem(item);
  }

  @Override
  public void deleteItem(long id) {

    this.ordermanagement.deleteItem(id);
  }

  @Override
  public Page<ItemEto> findItems(ItemSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findItems(searchCriteriaTo);
  }

}
