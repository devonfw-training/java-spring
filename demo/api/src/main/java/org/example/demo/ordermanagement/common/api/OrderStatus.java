package org.example.demo.ordermanagement.common.api;

/**
 * Status of {@link Order} which is updated during the order process.
 */
public enum OrderStatus {

  /**
   * An open {@link Order}. {@link Item}s can still be added. Order is closed by moving to {@link #PAID} or
   * {@link #CANCELLED} state.
   */
  OPEN,

  /**
   * Regular end-state of an {@link Order} after it has been fully payed by the customer.
   */
  PAID,

  /**
   * Exceptional end-state of an {@link Order} in case the customer left (e.g. without getting served).
   */
  CANCELLED
}
