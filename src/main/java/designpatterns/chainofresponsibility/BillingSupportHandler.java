package designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillingSupportHandler extends DefaultSupportHandler {
  private static final Logger log = LoggerFactory.getLogger(BillingSupportHandler.class);

  @Override
  public void handleRequest(Request request) {
    if(request.getType().equals(RequestType.BILLING)) {
      log.info("Billing support.");
    }
    else {
      this.next.handleRequest(request);
    }
  }
}
