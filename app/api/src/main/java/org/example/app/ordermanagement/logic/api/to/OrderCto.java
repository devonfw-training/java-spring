package org.example.app.ordermanagement.logic.api.to;

import java.util.List;

import com.devonfw.module.basic.common.api.to.MasterCto;

/**
 * Composite transport object of Order
 */
public class OrderCto extends MasterCto<OrderEto> {

  private static final long serialVersionUID = 1L;

  private OrderEto eto;

  private List<ItemEto> items;

  @Override
  public OrderEto getEto() {

    return this.eto;
  }

  @Override
  public void setEto(OrderEto order) {

    this.eto = order;
  }

  /**
   * @return the {@link List} of {@link ItemEto items} for the {@link #getEto() order}.
   */
  public List<ItemEto> getItems() {

    return this.items;
  }

  /**
   * @param items new value of {@link #getItems()}.
   */
  public void setItems(List<ItemEto> items) {

    this.items = items;
  }

}
