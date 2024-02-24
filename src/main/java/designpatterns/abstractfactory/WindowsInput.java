package designpatterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowsInput implements Input {

  private static final Logger log = LoggerFactory.getLogger(WindowsInput.class);
  @Override
  public void render() {
    log.info("Rendering Windows Input.");
  }
}
