package org.example.app.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import org.example.app.general.logic.base.AbstractUc;
import org.example.app.ordermanagement.dataaccess.api.repo.ItemRepository;

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
