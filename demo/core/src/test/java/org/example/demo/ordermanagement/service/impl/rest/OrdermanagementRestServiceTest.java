package org.example.demo.ordermanagement.service.impl.rest;

import java.math.BigDecimal;

import org.example.demo.general.service.base.test.RestServiceTest;
import org.example.demo.ordermanagement.logic.api.to.OrderEto;
import org.example.demo.ordermanagement.service.api.rest.OrdermanagementRestService;
import org.junit.jupiter.api.Test;

import com.devonfw.module.service.common.api.client.config.ServiceClientConfigBuilder;

/**
 * Test of {@link OrdermanagementRestService}. This test will start the entire application with spring-boot and tomcat
 * on a free random port. When the server is started, the test method is run that will communicate with the server via
 * HTTP and do all JSON mapping to test the REST-Service.
 */
public class OrdermanagementRestServiceTest extends RestServiceTest {
  @Test
  public void testFindOrder() {

    String login = "waiter";
    String password = "waiter";
    OrdermanagementRestService service = getServiceClientFactory().create(OrdermanagementRestService.class,
        new ServiceClientConfigBuilder().host("localhost").authBasic().userLogin(login).userPassword(password)
            .buildMap());
    OrderEto order = service.findOrder(1L);
    assertThat(order.getPrice()).isEqualTo(new BigDecimal("25.50"));
  }
}
