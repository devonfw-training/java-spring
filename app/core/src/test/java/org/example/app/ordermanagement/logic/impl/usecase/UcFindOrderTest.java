package org.example.app.ordermanagement.logic.impl.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.general.common.base.test.ApplicationComponentTest;
import org.example.app.general.common.base.test.TestUtil;
import org.example.app.ordermanagement.logic.api.to.OrderEto;
import org.example.app.ordermanagement.logic.api.usecase.UcFindOrder;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

/**
 * Test of {@link UcFindOrder} ({@link UcFindOrderImpl}).
 */
public class UcFindOrderTest extends ApplicationComponentTest {

  @Inject
  private UcFindOrderImpl ucFindOrder;

  @Test
  public void testFindOrder() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ORDER);
    OrderEto order = this.ucFindOrder.findOrder(1L);
    assertThat(order).isNotNull();
    assertThat(order.getPrice()).isEqualTo(new BigDecimal("25.50"));
  }

  @Test
  public void testFindOrderWithoutLogin() {

    assertThrows(AuthenticationCredentialsNotFoundException.class, () -> this.ucFindOrder.findOrder(1L));
  }

  @Test
  public void testFindOrderWithoutPermission() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ITEM);
    assertThrows(AccessDeniedException.class, () -> this.ucFindOrder.findOrder(1L));
  }
}
