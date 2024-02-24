package designpatterns.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * Serialization safe initialization of singleton class.
 */
public class SingletonWithSerialization implements Serializable {

  private static final SingletonWithSerialization INSTANCE;

  static {
    INSTANCE = new SingletonWithSerialization();
  }

  private SingletonWithSerialization() {}

  public static SingletonWithSerialization getInstance() {
    return INSTANCE;
  }

  @Serial
  protected Object readResolve() {
    return INSTANCE;
  }
}
