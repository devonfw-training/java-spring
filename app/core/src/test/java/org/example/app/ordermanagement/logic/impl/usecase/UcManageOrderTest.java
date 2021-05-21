package org.example.app.ordermanagement.logic.impl.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.Instant;

import javax.inject.Inject;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.general.common.base.test.ApplicationComponentTest;
import org.example.app.general.common.base.test.TestUtil;
import org.example.app.ordermanagement.common.api.OrderStatus;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.usecase.UcManageOrder;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

/**
 * Test of {@link UcManageOrder} ({@link UcManageOrderImpl}).
 */
public class UcManageOrderTest extends ApplicationComponentTest {

  @Inject
  private UcManageOrderImpl ucManageOrder;

  @Test
  public void testSaveAndDeleteOrder() {

    // given
    OrderEto order = new OrderEto();
    order.setPrice(BigDecimal.ONE);
    order.setCreationDate(Instant.now());
    order.setStatus(OrderStatus.OPEN);
    // when
    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_SAVE_ORDER,
        ApplicationAccessControlConfig.PERMISSION_DELETE_ORDER);
    order = this.ucManageOrder.saveOrder(order);
    // then
    assertThat(order).isNotNull();
    assertThat(order.getId()).isNotNull();
    // cleanup
    this.ucManageOrder.deleteOrder(order.getId());
  }

  @Test
  public void testSaveOrderWithoutLogin() {

    assertThrows(AuthenticationCredentialsNotFoundException.class, () -> this.ucManageOrder.saveOrder(new OrderEto()));
  }

  @Test
  public void testSaveOrderWithoutPermission() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ORDER);
    assertThrows(AccessDeniedException.class, () -> this.ucManageOrder.saveOrder(new OrderEto()));
  }

  @Test
  public void testDeleteOrderWithoutLogin() {

    assertThrows(AuthenticationCredentialsNotFoundException.class, () -> this.ucManageOrder.deleteOrder(-1L));
  }

  @Test
  public void testDeleteOrderWithoutPermission() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ORDER);
    assertThrows(AccessDeniedException.class, () -> this.ucManageOrder.deleteOrder(-1L));
  }
}
