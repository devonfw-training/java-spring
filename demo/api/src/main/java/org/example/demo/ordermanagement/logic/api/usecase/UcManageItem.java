package org.example.demo.ordermanagement.logic.api.usecase;

import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;

/**
 * Use-case for standard write operations (create/update/delete) of {@link Item}s.
 */
public interface UcManageItem {

  /**
   * @param itemId {@link Item#getId() primary key} of {@link Item} to delete.
   */
  void deleteItem(Long itemId);

  /**
   * @param item the {@link ItemEto} to create or update.
   * @return the {@link ItemEto} that has been saved with {@link ItemEto#getId() ID} and
   *         {@link ItemEto#getModificationCounter() modification counter}.
   */
  ItemEto saveItem(ItemEto item);

}
