package designpatterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Report implements Document {

  private static final Logger log = LoggerFactory.getLogger(Report.class);
  @Override
  public void open() {
    log.info("Opening Report.");
  }

  @Override
  public void save() {
    log.info("Saving Report.");
  }

  @Override
  public void close() {
    log.info("Closing Report.");
  }
}
