package org.example.app.general.common.base.test;

import org.example.app.SpringBootApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.module.test.common.base.ComponentDbTest;
import com.devonfw.module.test.common.base.ComponentTest;

/**
 * Abstract base class for {@link ComponentTest}s of this application.
 */
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.MOCK)
public abstract class ApplicationComponentTest extends ComponentDbTest {

  @Override
  protected void doTearDown() {

    super.doTearDown();
    TestUtil.logout();
  }

}
