package org.example.app.ordermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Iterator;

import org.example.app.ordermanagement.common.api.OrderStatus;
import org.example.app.ordermanagement.dataaccess.api.OrderEntity;
import org.example.app.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

public interface OrderRepository extends DefaultRepository<OrderEntity> {

  /**
   * @param criteria the {@link OrderSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link OrderEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<OrderEntity> findByCriteria(OrderSearchCriteriaTo criteria) {

    OrderEntity alias = newDslAlias();
    JPAQuery<OrderEntity> query = newDslQuery(alias);

    BigDecimal price = criteria.getPrice();
    if (price != null) {
      query.where($(alias.getPrice()).eq(price));
    }
    Instant creationDate = criteria.getCreationDate();
    if (creationDate != null) {
      query.where($(alias.getCreationDate()).eq(creationDate));
    }
    Instant paymentDate = criteria.getPaymentDate();
    if (paymentDate != null) {
      query.where($(alias.getPaymentDate()).eq(paymentDate));
    }
    OrderStatus status = criteria.getStatus();
    if (status != null) {
      query.where($(alias.getStatus()).eq(status));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   *
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<OrderEntity> query, OrderEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "price":
            if (next.isAscending()) {
              query.orderBy($(alias.getPrice()).asc());
            } else {
              query.orderBy($(alias.getPrice()).desc());
            }
            break;
          case "creationDate":
            if (next.isAscending()) {
              query.orderBy($(alias.getCreationDate()).asc());
            } else {
              query.orderBy($(alias.getCreationDate()).desc());
            }
            break;
          case "paymentDate":
            if (next.isAscending()) {
              query.orderBy($(alias.getPaymentDate()).asc());
            } else {
              query.orderBy($(alias.getPaymentDate()).desc());
            }
            break;
          case "status":
            if (next.isAscending()) {
              query.orderBy($(alias.getStatus()).asc());
            } else {
              query.orderBy($(alias.getStatus()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
