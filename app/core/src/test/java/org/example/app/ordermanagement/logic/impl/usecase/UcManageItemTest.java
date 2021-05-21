package org.example.app.ordermanagement.logic.impl.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.Instant;

import javax.inject.Inject;

import org.example.app.general.common.api.security.ApplicationAccessControlConfig;
import org.example.app.general.common.base.test.ApplicationComponentTest;
import org.example.app.general.common.base.test.TestUtil;
import org.example.app.ordermanagement.logic.api.to.ItemEto;
import org.example.app.ordermanagement.logic.api.usecase.UcManageItem;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

/**
 * Test of {@link UcManageItem} ({@link UcManageItemImpl}).
 */
public class UcManageItemTest extends ApplicationComponentTest {

  @Inject
  private UcManageItemImpl ucManageItem;

  @Test
  public void testSaveAndDeleteItem() {

    // given
    ItemEto item = new ItemEto();
    item.setName("Test Item");
    item.setPrice(BigDecimal.ONE);
    item.setCreationDate(Instant.now());
    item.setOrderId(1L);
    // when
    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_SAVE_ITEM,
        ApplicationAccessControlConfig.PERMISSION_DELETE_ITEM);
    item = this.ucManageItem.saveItem(item);
    // then
    assertThat(item).isNotNull();
    assertThat(item.getId()).isNotNull();
    // cleanup
    this.ucManageItem.deleteItem(item.getId());
  }

  @Test
  public void testSaveItemWithoutLogin() {

    assertThrows(AuthenticationCredentialsNotFoundException.class, () -> this.ucManageItem.saveItem(new ItemEto()));
  }

  @Test
  public void testSaveItemWithoutPermission() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ITEM);
    assertThrows(AccessDeniedException.class, () -> this.ucManageItem.saveItem(new ItemEto()));
  }

  @Test
  public void testDeleteItemWithoutLogin() {

    assertThrows(AuthenticationCredentialsNotFoundException.class, () -> this.ucManageItem.deleteItem(-1L));
  }

  @Test
  public void testDeleteItemWithoutPermission() {

    TestUtil.login("user", ApplicationAccessControlConfig.PERMISSION_FIND_ITEM);
    assertThrows(AccessDeniedException.class, () -> this.ucManageItem.deleteItem(-1L));
  }
}
