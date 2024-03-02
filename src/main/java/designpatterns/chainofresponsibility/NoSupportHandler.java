package designpatterns.chainofresponsibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSupportHandler extends DefaultSupportHandler {
  private static final Logger log = LoggerFactory.getLogger(NoSupportHandler.class);

  @Override
  public void handleRequest(Request request) {
    log.info("No support handler.");
  }
}
