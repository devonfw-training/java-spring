package org.example.app.ordermanagement.logic.impl.usecase;

import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.ordermanagement.dataaccess.api.ItemEntity;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.example.app.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.app.ordermanagement.logic.base.usecase.AbstractItemUc;
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
public class UcFindItemImpl extends AbstractItemUc implements UcFindItem {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_ITEM)
  public ItemEto findItem(long id) {

    LOG.debug("Get Item with id {} from database.", id);
    Optional<ItemEntity> foundEntity = getItemRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), ItemEto.class);
    else
      return null;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_ITEM)
  public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {

    Page<ItemEntity> items = getItemRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(items, ItemEto.class);
  }

}
