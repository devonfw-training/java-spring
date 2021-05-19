package org.example.app.ordermanagement.logic.api;

import org.example.app.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.app.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.app.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.app.ordermanagement.logic.api.usecase.UcManageOrder;

/**
 * Interface for Ordermanagement component.
 */
public interface Ordermanagement extends UcFindItem, UcManageItem, UcFindOrder, UcManageOrder {

}
