package designpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsButton implements Button {

  private static final Logger log = LoggerFactory.getLogger(WindowsButton.class);
  @Override
  public void render() {
    log.info("Rendering Windows Button.");
  }
}
