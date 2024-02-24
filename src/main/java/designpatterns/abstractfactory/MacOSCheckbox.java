package designpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MacOSCheckbox implements Checkbox {

  private static final Logger log = LoggerFactory.getLogger(MacOSCheckbox.class);
  @Override
  public void render() {
    log.info("Rendering MacOS Checkbox.");
  }
}
