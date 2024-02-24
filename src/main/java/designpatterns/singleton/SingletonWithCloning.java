package designpatterns.singleton;

/**
 * Eager initialization of singleton class.
 */
public class SingletonWithCloning implements Cloneable {

  private SingletonWithCloning() {}

  private static final SingletonWithCloning INSTANCE;

  static {
    INSTANCE = new SingletonWithCloning();
  }

  public static SingletonWithCloning getInstance() {
    return INSTANCE;
  }

  @Override
  public SingletonWithCloning clone() throws CloneNotSupportedException {
    super.clone();
    return INSTANCE;
  }
}
