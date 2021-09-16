package org.example.app.moviemanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.example.app.moviemanagement.dataaccess.api.MovieEntity;
import org.example.app.moviemanagement.logic.api.to.MovieSearchCriteriaTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link MovieEntity}
 */
public interface MovieRepository extends DefaultRepository<MovieEntity> {

  /**
   * @param criteria the {@link MovieSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link MovieEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<MovieEntity> findByCriteria(MovieSearchCriteriaTo criteria) {

    MovieEntity alias = newDslAlias();
    JPAQuery<MovieEntity> query = newDslQuery(alias);

    String title = criteria.getTitle();
    if (title != null && !title.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getTitle()), title, criteria.getTitleOption());
    }
    Integer year = criteria.getYear();
    if (year != null) {
      query.where($(alias.getYear()).eq(year));
    }
    String genres = criteria.getGenres();
    if (genres != null && !genres.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getGenres().get(0).getName()), genres, criteria.getGenresOption());
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
  public default void addOrderBy(JPAQuery<MovieEntity> query, MovieEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "title":
            if (next.isAscending()) {
              query.orderBy($(alias.getTitle()).asc());
            } else {
              query.orderBy($(alias.getTitle()).desc());
            }
            break;
          case "year":
            if (next.isAscending()) {
              query.orderBy($(alias.getYear()).asc());
            } else {
              query.orderBy($(alias.getYear()).desc());
            }
            break;
          case "genres":
            if (next.isAscending()) {
              query.orderBy($(alias.getGenres().get(0).getName()).asc());
            } else {
              query.orderBy($(alias.getGenres().get(0).getName()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
