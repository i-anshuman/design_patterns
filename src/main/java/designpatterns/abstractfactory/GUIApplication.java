package designpatterns.abstractfactory;

public class GUIApplication {

  private GUIApplication() {}

  public static GUIFactory getGUIFactory(OSTypes type) {
    return switch (type) {
      case WINDOWS -> new WindowsGUIFactory();
      case MACOS -> new MacOSFactory();
    };
  }
}
