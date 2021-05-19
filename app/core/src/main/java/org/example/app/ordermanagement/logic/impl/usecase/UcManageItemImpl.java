package org.example.app.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.example.app.ordermanagement.dataaccess.api.ItemEntity;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.app.ordermanagement.logic.base.usecase.AbstractItemUc;
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
public class UcManageItemImpl extends AbstractItemUc implements UcManageItem {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageItemImpl.class);

  @Override
  public boolean deleteItem(long itemId) {

    ItemEntity item = getItemRepository().find(itemId);
    getItemRepository().delete(item);
    LOG.debug("The item with id '{}' has been deleted.", itemId);
    return true;
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
