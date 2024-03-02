package designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TechnicalSupportHandler extends DefaultSupportHandler {
  private static final Logger log = LoggerFactory.getLogger(TechnicalSupportHandler.class);

  @Override
  public void handleRequest(Request request) {
    if(request.getType().equals(RequestType.TECHNICAL)) {
      log.info("Technical support.");
    }
    else {
      this.next.handleRequest(request);
    }
  }
}
