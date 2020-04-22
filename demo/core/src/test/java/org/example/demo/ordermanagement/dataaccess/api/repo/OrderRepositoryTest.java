package org.example.demo.ordermanagement.dataaccess.api.repo;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.example.demo.SpringBootApp;
import org.example.demo.ordermanagement.dataaccess.api.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.module.test.common.base.ComponentDbTest;

/**
 * Test of {@link OrderRepository}.
 */
@SpringBootTest(classes = SpringBootApp.class, webEnvironment = WebEnvironment.MOCK)
public class OrderRepositoryTest extends ComponentDbTest {

  @Inject
  private OrderRepository orderRepository;

  @Test
  public void testFindOrder() {

    OrderEntity order = this.orderRepository.find(1L);
    assertThat(order).isNotNull();
    assertThat(order.getPrice()).isEqualTo(new BigDecimal("25.50"));
  }

}
