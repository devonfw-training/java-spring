package org.example.demo.ordermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ordermanagement.logic.api.Ordermanagement;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.service.api.rest.OrdermanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Named("OrdermanagementRestService")
public class OrdermanagementRestServiceImpl implements OrdermanagementRestService {

  @Inject
  private Ordermanagement ordermanagement;

  @Override
  public OrderEto findOrder(long id) {

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
  public ItemEto findItem(long id) {

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

}
