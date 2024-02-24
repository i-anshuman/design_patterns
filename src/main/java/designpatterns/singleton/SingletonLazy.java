package designpatterns.singleton;

/**
 * Lazy initialization of singleton class.
 */
public class SingletonLazy {

  private static SingletonLazy instance;

  private SingletonLazy() {}

  // Thread unsafe.
  public static SingletonLazy getInstance() {
    if(instance == null) {
      instance = new SingletonLazy();
    }
    return instance;
  }
}
