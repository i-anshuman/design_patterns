package designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductSupportHandler extends DefaultSupportHandler {
  private static final Logger log = LoggerFactory.getLogger(ProductSupportHandler.class);

  @Override
  public void handleRequest(Request request) {
    if(request.getType().equals(RequestType.PRODUCT)) {
      log.info("Product support.");
    }
    else {
      this.next.handleRequest(request);
    }
  }
}
