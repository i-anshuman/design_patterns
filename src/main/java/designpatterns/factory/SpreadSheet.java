package designpatterns.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpreadSheet implements Document {

  private static final Logger log = LoggerFactory.getLogger(SpreadSheet.class);
  @Override
  public void open() {
    log.info("Opening SpreadSheet.");
  }

  @Override
  public void save() {
    log.info("Saving SpreadSheet.");
  }

  @Override
  public void close() {
    log.info("Closing SpreadSheet.");
  }
}
