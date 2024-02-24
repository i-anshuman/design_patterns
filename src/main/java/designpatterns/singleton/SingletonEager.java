package designpatterns.singleton;

/**
 * Eager initialization of singleton class.
 */
public class SingletonEager {

  private SingletonEager() {}

  private static final SingletonEager INSTANCE;

  static {
    INSTANCE = new SingletonEager();
  }

  public static SingletonEager getInstance() {
    return INSTANCE;
  }
}
