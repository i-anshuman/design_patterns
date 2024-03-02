package designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralSupportHandler extends DefaultSupportHandler {
  private static final Logger log = LoggerFactory.getLogger(GeneralSupportHandler.class);

  @Override
  public void handleRequest(Request request) {
    if(request.getType().equals(RequestType.GENERAL)) {
      log.info("General support.");
    }
    else {
      this.next.handleRequest(request);
    }
  }
}
