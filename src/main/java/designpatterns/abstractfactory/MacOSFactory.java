package designpatterns.abstractfactory;

public class MacOSFactory implements GUIFactory {
  @Override
  public Input createInput() {
    return new MacOSInput();
  }

  @Override
  public Checkbox createCheckbox() {
    return new MacOSCheckbox();
  }

  @Override
  public Button createButton() {
    return new MacOSButton();
  }
}
