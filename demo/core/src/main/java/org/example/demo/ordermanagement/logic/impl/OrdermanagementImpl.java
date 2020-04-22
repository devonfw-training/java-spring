package org.example.demo.ordermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.general.logic.base.AbstractComponentFacade;
import org.example.demo.ordermanagement.logic.api.Ordermanagement;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageOrder;

/**
 * Implementation of component interface of ordermanagement
 */
@Named
public class OrdermanagementImpl extends AbstractComponentFacade implements Ordermanagement {

  @Inject
  private UcFindOrder ucFindOrder;

  @Inject
  private UcManageOrder ucManageOrder;

  @Inject
  private UcFindItem ucFindItem;

  @Inject
  private UcManageItem ucManageItem;

  @Override
  public OrderEto findOrder(Long id) {

    return this.ucFindOrder.findOrder(id);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ucManageOrder.saveOrder(order);
  }

  @Override
  public void deleteOrder(Long orderId) {

    this.ucManageOrder.deleteOrder(orderId);
  }

  @Override
  public ItemEto findItem(Long id) {

    return this.ucFindItem.findItem(id);
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    return this.ucManageItem.saveItem(item);
  }

  @Override
  public void deleteItem(Long id) {

    this.ucManageItem.deleteItem(id);
  }

}
