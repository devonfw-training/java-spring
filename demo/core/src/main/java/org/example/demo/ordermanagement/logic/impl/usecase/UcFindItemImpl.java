package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.general.logic.base.AbstractUc;
import org.example.demo.ordermanagement.dataaccess.api.ItemEntity;
import org.example.demo.ordermanagement.dataaccess.api.repo.ItemRepository;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for searching, filtering and getting Items
 */
@Named
@Validated
@Transactional
public class UcFindItemImpl extends AbstractUc implements UcFindItem {

  private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

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

  @Override
  public ItemEto findItem(Long id) {

    if (id != null) {
      LOG.debug("Get Item with id {} from database.", id);
      Optional<ItemEntity> foundEntity = getItemRepository().findById(id);
      if (foundEntity.isPresent()) {
        return getBeanMapper().map(foundEntity.get(), ItemEto.class);
      }
    }
    return null;
  }

  @Override
  public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {

    Page<ItemEntity> items = getItemRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(items, ItemEto.class);
  }

}
