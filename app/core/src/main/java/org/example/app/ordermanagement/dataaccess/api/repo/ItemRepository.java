package org.example.app.ordermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Iterator;

import org.example.app.ordermanagement.dataaccess.api.ItemEntity;
import org.example.app.ordermanagement.logic.api.to.ItemSearchCriteriaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

public interface ItemRepository extends DefaultRepository<ItemEntity> {

  /**
   * @param criteria the {@link ItemSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link ItemEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<ItemEntity> findByCriteria(ItemSearchCriteriaTo criteria) {

    ItemEntity alias = newDslAlias();
    JPAQuery<ItemEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    BigDecimal price = criteria.getPrice();
    if (price != null) {
      query.where($(alias.getPrice()).eq(price));
    }
    Long order = criteria.getOrderId();
    if (order != null) {
      query.where($(alias.getOrder().getId()).eq(order));
    }
    Instant creationDate = criteria.getCreationDate();
    if (creationDate != null) {
      query.where($(alias.getCreationDate()).eq(creationDate));
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
  public default void addOrderBy(JPAQuery<ItemEntity> query, ItemEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "name":
            if (next.isAscending()) {
              query.orderBy($(alias.getName()).asc());
            } else {
              query.orderBy($(alias.getName()).desc());
            }
            break;
          case "price":
            if (next.isAscending()) {
              query.orderBy($(alias.getPrice()).asc());
            } else {
              query.orderBy($(alias.getPrice()).desc());
            }
            break;
          case "order":
            if (next.isAscending()) {
              query.orderBy($(alias.getOrder().getId().toString()).asc());
            } else {
              query.orderBy($(alias.getOrder().getId().toString()).desc());
            }
            break;
          case "creationDate":
            if (next.isAscending()) {
              query.orderBy($(alias.getCreationDate()).asc());
            } else {
              query.orderBy($(alias.getCreationDate()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
