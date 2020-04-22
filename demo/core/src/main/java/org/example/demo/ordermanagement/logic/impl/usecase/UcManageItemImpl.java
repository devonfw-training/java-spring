package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.dataaccess.api.ItemEntity;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.demo.ordermanagement.logic.base.usecase.AbstractItemUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for modifying and deleting Items
 */
@Named
@Validated
@Transactional
public class UcManageItemImpl extends AbstractItemUc implements UcManageItem {

  private static final Logger LOG = LoggerFactory.getLogger(UcManageItemImpl.class);

  @Override
  public void deleteItem(IdRef<Item> itemId) {

    if (itemId == null) {
      return;
    }
    ItemEntity item = getItemRepository().find(itemId.getId());
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
