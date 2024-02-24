package designpatterns.abstractfactory;

public class WindowsGUIFactory implements GUIFactory {
  @Override
  public Input createInput() {
    return new WindowsInput();
  }

  @Override
  public Checkbox createCheckbox() {
    return new WindowsCheckbox();
  }

  @Override
  public Button createButton() {
    return new WindowsButton();
  }
}
