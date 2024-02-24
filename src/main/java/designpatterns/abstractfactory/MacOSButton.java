package designpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MacOSButton implements Button {

  private static final Logger log = LoggerFactory.getLogger(MacOSButton.class);
  @Override
  public void render() {
    log.info("Rendering MacOS Button.");
  }
}
