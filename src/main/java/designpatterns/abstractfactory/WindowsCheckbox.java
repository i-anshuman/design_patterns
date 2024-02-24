package designpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsCheckbox implements Checkbox {

  private static final Logger log = LoggerFactory.getLogger(WindowsCheckbox.class);
  @Override
  public void render() {
    log.info("Rendering Windows Checkbox.");
  }
}
