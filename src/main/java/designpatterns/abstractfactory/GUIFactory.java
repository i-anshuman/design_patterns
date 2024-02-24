package designpatterns.abstractfactory;

public interface GUIFactory {
  Input createInput();
  Checkbox createCheckbox();
  Button createButton();
}
