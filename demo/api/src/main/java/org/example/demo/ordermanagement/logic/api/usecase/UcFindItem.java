package org.example.demo.ordermanagement.logic.api.usecase;

import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;

/**
 * Use-case to search and find {@link Item}s.
 */
public interface UcFindItem {

  /**
   * @param id {@link ItemEto#getId() primary key} of {@link Item} to find.
   * @return the {@link ItemEto} with given ID or {@code null} if not exists.
   */
  ItemEto findItem(Long id);

}
