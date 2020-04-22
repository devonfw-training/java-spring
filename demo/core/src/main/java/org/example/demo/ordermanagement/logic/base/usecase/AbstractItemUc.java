package org.example.demo.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import org.example.demo.general.logic.base.AbstractUc;
import org.example.demo.ordermanagement.dataaccess.api.repo.ItemRepository;

/**
 * Abstract use case for Items, which provides access to the commonly necessary data access objects.
 */
public class AbstractItemUc extends AbstractUc {

  /** @see #getItemRepository() */
  @Inject
  private ItemRepository itemRepository;

  /**
   * Returns the field 'itemRepository'.
   * 
   * @return the {@link ItemRepository} instance.
   */
  public ItemRepository getItemRepository() {

    return this.itemRepository;
  }

}
