package org.example.app.dummy.common.api;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ComponentATest extends ComponentTest {

  @Inject
  private ComponentA componentA;

  @Test
  public void testGreet() {

    // given
    String expected = "Hello World";

    // when
    String actual = this.componentA.greet();

    // then
    assertThat(actual).isEqualTo(expected);
  }
}
