package org.example.app.ordermanagement.logic.api.usecase;

import java.util.List;

import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.springframework.data.domain.Page;

/**
 * Use-case to search and find {@link org.example.app.ordermanagement.common.api.Item}s.
 */
public interface UcFindItem {

  /**
   * Returns a Item by its id 'id'.
   *
   * @param id The id 'id' of the Item.
   * @return The {@link ItemEto} with id 'id'
   */
  ItemEto findItem(long id);

  /**
   * Returns a paginated list of Items matching the search criteria.
   *
   * @param criteria the {@link ItemSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ItemEto}s.
   */
  Page<ItemEto> findItems(ItemSearchCriteriaTo criteria);

}
