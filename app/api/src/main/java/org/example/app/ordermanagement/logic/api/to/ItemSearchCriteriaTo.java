package org.example.app.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.app.general.common.api.to.AbstractSearchCriteriaTo;

import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link org.example.app.ordermanagement.common.api.Item}s.
 */
public class ItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private Long orderId;

  private Instant creationDate;

  private StringSearchConfigTo nameOption;

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

  /**
   * @return creationDateId
   */

  public Instant getCreationDate() {

    return creationDate;
  }

  /**
   * @param creationDate setter for creationDate attribute
   */

  public void setCreationDate(Instant creationDate) {

    this.creationDate = creationDate;
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

}
