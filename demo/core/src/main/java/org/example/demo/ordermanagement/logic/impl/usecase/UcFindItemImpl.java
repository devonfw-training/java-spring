package org.example.demo.ordermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.example.demo.ordermanagement.common.api.Item;
import org.example.demo.ordermanagement.dataaccess.api.ItemEntity;
import org.example.demo.ordermanagement.logic.api.to.ItemEto;
import org.example.demo.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.demo.ordermanagement.logic.base.usecase.AbstractItemUc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for searching, filtering and getting Items
 */
@Named
@Validated
@Transactional
public class UcFindItemImpl extends AbstractItemUc implements UcFindItem {

  private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

  @Override
  public ItemEto findItem(IdRef<Item> id) {

    Long itemId = null;
    if (id != null) {
      itemId = id.getId();
    }
    if (itemId != null) {
      LOG.debug("Get Item with id {} from database.", itemId);
      Optional<ItemEntity> foundEntity = getItemRepository().findById(itemId);
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
