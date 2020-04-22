package org.example.demo.ordermanagement.logic.api;

import org.example.demo.ordermanagement.logic.api.usecase.UcFindItem;
import org.example.demo.ordermanagement.logic.api.usecase.UcFindOrder;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageItem;
import org.example.demo.ordermanagement.logic.api.usecase.UcManageOrder;

/**
 * Interface for Ordermanagement component.
 */
public interface Ordermanagement extends UcFindOrder, UcManageOrder, UcFindItem, UcManageItem {

}
