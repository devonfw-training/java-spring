package org.example.demo.ordermanagement.logic.api.usecase;

import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use-case for standard write operations (create/update/delete) of {@link Item}s.
 */
public interface UcManageItem {

  /**
   * @param itemId {@link IdRef} of {@link Item} to delete.
   */
  void deleteItem(IdRef<Item> itemId);

  /**
   * @param item the {@link ItemEto} to create or update.
   * @return the {@link ItemEto} that has been saved with {@link ItemEto#getId() ID} and
   *         {@link ItemEto#getModificationCounter() modification counter}.
   */
  ItemEto saveItem(ItemEto item);

}
