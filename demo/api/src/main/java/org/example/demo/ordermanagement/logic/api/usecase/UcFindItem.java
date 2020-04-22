package org.example.demo.ordermanagement.logic.api.usecase;

import java.util.List;

import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.springframework.data.domain.Page;

/**
 * Use-case to search and find {@link Item}s.
 */
public interface UcFindItem {

  /**
   * @param id {@link ItemEto#getId() primary key} of {@link Item} to find.
   * @return the {@link ItemEto} with given ID or {@code null} if not exists.
   */
  ItemEto findItem(Long id);

  /**
   * Returns a paginated list of Items matching the search criteria.
   *
   * @param criteria the {@link ItemSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ItemEto}s.
   */
  Page<ItemEto> findItems(ItemSearchCriteriaTo criteria);

}
