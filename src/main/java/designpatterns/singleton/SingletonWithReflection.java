package designpatterns.singleton;

public class SingletonWithReflection {

  private static final SingletonWithReflection INSTANCE;

  private SingletonWithReflection() {
    if(INSTANCE == null) {
      throw new IllegalStateException("Singleton instance already exists.");
    }
  }

  static {
    INSTANCE = new SingletonWithReflection();
  }

  public static SingletonWithReflection getInstance() {
    return INSTANCE;
  }
}
