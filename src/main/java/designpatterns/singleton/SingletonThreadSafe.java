package designpatterns.singleton;

/**
 * Thread safe lazy initialization of singleton class.
 */
public class SingletonThreadSafe {

  private static volatile SingletonThreadSafe instance;

  private SingletonThreadSafe() {}

  public static SingletonThreadSafe getInstance() {
    if(instance == null) {
      synchronized (SingletonThreadSafe.class) {
        if(instance == null) {
          instance = new SingletonThreadSafe();
        }
      }
    }
    return instance;
  }
}
