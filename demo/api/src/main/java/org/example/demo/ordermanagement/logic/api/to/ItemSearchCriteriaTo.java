package org.example.demo.ordermanagement.logic.api.to;

import java.math.BigDecimal;

import org.example.demo.general.common.api.to.AbstractSearchCriteriaTo;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link org.example.demo.ordermanagement.common.api.Item}s.
 */
public class ItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private BigDecimal price;

  private StringSearchConfigTo nameOption;

  private StringSearchConfigTo descriptionOption;

  private Long orderId;

  /**
   * @return nameId
   */
  public String getName() {

    return name;
  }

  /**
   * @param name setter for name attribute
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return descriptionId
   */
  public String getDescription() {

    return description;
  }

  /**
   * @param description setter for description attribute
   */
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return priceId
   */
  public BigDecimal getPrice() {

    return price;
  }

  /**
   * @param price setter for price attribute
   */
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getName() name}.
   */
  public StringSearchConfigTo getNameOption() {

    return this.nameOption;
  }

  /**
   * @param nameOption new value of {@link #getNameOption()}.
   */
  public void setNameOption(StringSearchConfigTo nameOption) {

    this.nameOption = nameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getDescription() description}.
   */
  public StringSearchConfigTo getDescriptionOption() {

    return this.descriptionOption;
  }

  /**
   * @param descriptionOption new value of {@link #getDescriptionOption()}.
   */
  public void setDescriptionOption(StringSearchConfigTo descriptionOption) {

    this.descriptionOption = descriptionOption;
  }

  /**
   * getter for orderId attribute
   *
   * @return orderId
   */
  public Long getOrderId() {

    return orderId;
  }

  /**
   * @param order setter for order attribute
   */
  public void setOrderId(Long orderId) {

    this.orderId = orderId;
  }

}
