package org.example.app.ordermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.app.general.logic.base.AbstractComponentFacade;
import org.example.app.ordermanagement.logic.api.Ordermanagement;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.example.app.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.app.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.app.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.app.ordermanagement.logic.api.usecase.UcManageOrder;
import org.springframework.data.domain.Page;

/**
 * Implementation of component interface of ordermanagement
 */
@Named
public class OrdermanagementImpl extends AbstractComponentFacade implements Ordermanagement {

  @Inject
  private UcFindItem ucFindItem;

  @Inject
  private UcManageItem ucManageItem;

  @Inject
  private UcFindOrder ucFindOrder;

  @Inject
  private UcManageOrder ucManageOrder;

  @Override
  public ItemEto findItem(long id) {

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
  public boolean deleteItem(long id) {

    return this.ucManageItem.deleteItem(id);
  }

  @Override
  public OrderEto findOrder(long id) {

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
  public boolean deleteOrder(long id) {

    return this.ucManageOrder.deleteOrder(id);
  }

}
