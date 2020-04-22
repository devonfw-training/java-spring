package org.example.demo.ordermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.general.logic.base.AbstractComponentFacade;
import org.example.demo.ordermanagement.logic.api.Ordermanagement;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageOrder;
import org.springframework.data.domain.Page;

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
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    return this.ucFindOrder.findOrders(criteria);
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
  public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {

    return this.ucFindItem.findItems(criteria);
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