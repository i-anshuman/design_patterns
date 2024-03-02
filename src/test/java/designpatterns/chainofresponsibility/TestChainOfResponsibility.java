package designpatterns.chainofresponsibility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tags({ @Tag("Behavioural"), @Tag("Chain Of Responsibility") })
@DisplayName("Test chain of responsibility pattern.")
class TestChainOfResponsibility {

  private SupportHandler handler;

  @BeforeEach
  void setup() {
    handler = SupportHandlerChain.getDefaultChain();
  }

  @Test
  void case1() {
    handler.handleRequest(new Request(RequestType.BILLING, "Refund not initiated."));
  }

  @Test
  void case2() {
    handler.handleRequest(new Request(RequestType.TECHNICAL, "Unable to login."));
  }

  @Test
  void case3() {
    handler.handleRequest(new Request(RequestType.PRODUCT, "Discount on Product."));
  }

  @Test
  void case4() {
    handler.handleRequest(new Request(RequestType.GENERAL, "Coupon expiration duration."));
  }

  @Test
  void case5() {
    handler.handleRequest(new Request(RequestType.COMPLAINT, "Delay in delivery."));
  }
}
