package designpatterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Presentation implements Document {

  private static final Logger log = LoggerFactory.getLogger(Presentation.class);
  @Override
  public void open() {
    log.info("Opening Presentation.");
  }

  @Override
  public void save() {
    log.info("Saving Presentation.");
  }

  @Override
  public void close() {
    log.info("Closing Presentation.");
  }
}
