package org.example.app.ordermanagement.logic.impl.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.general.common.base.test.ApplicationComponentTest;
import org.example.app.general.common.base.test.TestUtil;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.usecase.UcFindItem;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

/**
 * Test of {@link UcFindItem} ({@link UcFindItemImpl}).
 */
public class UcFindItemTest extends ApplicationComponentTest {

  @Inject
  private UcFindItemImpl ucFindItem;

  @Test
  public void testFindItem() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ITEM);
    ItemEto item = this.ucFindItem.findItem(1L);
    assertThat(item).isNotNull();
    assertThat(item.getPrice()).isEqualTo(new BigDecimal("12.50"));
  }

  @Test
  public void testFindItemWithoutLogin() {

    assertThrows(AuthenticationCredentialsNotFoundException.class, () -> this.ucFindItem.findItem(1L));
  }

  @Test
  public void testFindItemWithoutPermission() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ORDER);
    assertThrows(AccessDeniedException.class, () -> this.ucFindItem.findItem(1L));
  }
}
