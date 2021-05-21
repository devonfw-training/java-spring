package org.example.app.general.common.api.security;

import javax.inject.Named;

import com.devonfw.module.security.common.api.accesscontrol.AccessControlGroup;
import com.devonfw.module.security.common.base.accesscontrol.AccessControlConfig;

/**
 * Example of {@link AccessControlConfig} that used for testing.
 */
@Named
public class ApplicationAccessControlConfig extends AccessControlConfig {

  public static final String APP_ID = "app";

  private static final String PREFIX = APP_ID + ".";

  public static final String GROUP_READ_MASTER_DATA = PREFIX + "ReadMasterData";

  public static final String PERMISSION_FIND_ORDER = PREFIX + "FindOrder";

  public static final String PERMISSION_SAVE_ORDER = PREFIX + "SaveOrder";

  public static final String PERMISSION_DELETE_ORDER = PREFIX + "DeleteOrder";

  public static final String PERMISSION_FIND_ITEM = PREFIX + "FindItem";

  public static final String PERMISSION_SAVE_ITEM = PREFIX + "SaveItem";

  public static final String PERMISSION_DELETE_ITEM = PREFIX + "DeleteItem";

  public static final String GROUP_ADMIN = "admin";

  public static final String GROUP_WAITER = "waiter";

  public static final String PERMISSION_FIND_MOVIE = PREFIX + "FindMovie";

  public static final String PERMISSION_SAVE_MOVIE = PREFIX + "SaveMovie";

  public static final String PERMISSION_DELETE_MOVIE = PREFIX + "DeleteMovie";

  /**
   * The constructor.
   */
  public ApplicationAccessControlConfig() {

    super();
    AccessControlGroup readMasterData = group(GROUP_READ_MASTER_DATA, PERMISSION_FIND_ITEM, PERMISSION_FIND_ORDER);
    group(GROUP_ADMIN, readMasterData, PERMISSION_FIND_MOVIE, PERMISSION_SAVE_MOVIE, PERMISSION_DELETE_MOVIE);
    AccessControlGroup waiter = group(GROUP_WAITER, readMasterData, PERMISSION_SAVE_ITEM, PERMISSION_SAVE_ORDER);
    group(GROUP_ADMIN, waiter, PERMISSION_DELETE_ITEM, PERMISSION_DELETE_ORDER);
  }

}