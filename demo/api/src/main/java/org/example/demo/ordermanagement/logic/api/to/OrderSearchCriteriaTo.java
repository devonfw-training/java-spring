package org.example.demo.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import org.example.demo.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of {@link org.example.demo.ordermanagement.common.api.Order}s.
 */
public class OrderSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private BigDecimal price;

  private Instant creationDate;

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

}
