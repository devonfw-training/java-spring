package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.general.logic.base.AbstractUc;
import org.example.demo.ordermanagement.dataaccess.api.ItemEntity;
import org.example.demo.ordermanagement.dataaccess.api.repo.ItemRepository;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for modifying and deleting Items
 */
@Named
@Validated
@Transactional
public class UcManageItemImpl extends AbstractUc implements UcManageItem {

  private static final Logger LOG = LoggerFactory.getLogger(UcManageItemImpl.class);

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
  public void deleteItem(Long itemId) {

    if (itemId == null) {
      return;
    }
    ItemEntity item = getItemRepository().find(itemId);
    getItemRepository().delete(item);
    LOG.debug("The item with id '{}' has been deleted.", itemId);
  }

  @Override
  public ItemEto saveItem(ItemEto item) {

    Objects.requireNonNull(item, "item");

    ItemEntity itemEntity = getBeanMapper().map(item, ItemEntity.class);

    // initialize, validate itemEntity here if necessary
    ItemEntity resultEntity = getItemRepository().save(itemEntity);
    LOG.debug("Item with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, ItemEto.class);
  }

}
