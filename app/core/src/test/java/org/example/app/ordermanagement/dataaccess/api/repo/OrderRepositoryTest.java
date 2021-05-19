package org.example.app.ordermanagement.dataaccess.api.repo;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.example.app.SpringBootApp;
import org.example.app.ordermanagement.dataaccess.api.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.module.test.common.base.ComponentDbTest;

@SpringBootTest(classes = SpringBootApp.class, webEnvironment = WebEnvironment.MOCK)
public class OrderRepositoryTest extends ComponentDbTest {

  @Inject
  private OrderRepository orderRepository;

  @Test
  public void testFindOrder() {

    // given
    Long orderId = Long.valueOf(1L);
    // when
    OrderEntity order = this.orderRepository.find(orderId);
    // then
    assertThat(order).isNotNull();
    assertThat(order.getPrice()).isEqualTo(new BigDecimal("25.50"));
    // ...
  }
}
