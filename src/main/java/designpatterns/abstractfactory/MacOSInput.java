package designpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MacOSInput implements Input {

  private static final Logger log = LoggerFactory.getLogger(MacOSInput.class);
  @Override
  public void render() {
    log.info("Rendering MacOS Input.");
  }
}
