package designpatterns.abstractfactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tags({ @Tag("Creation"), @Tag("Abstract Factory") })
@DisplayName("Test factory design pattern.")
class TestAbstractFactory {

  private GUIFactory factory;

  @Nested
  @Order(1)
  @DisplayName("Test Windows.")
  class TestWindows {

    @BeforeEach
    void setup() {
      factory = GUIApplication.getGUIFactory(OSTypes.WINDOWS);
    }

    @Test
    @Order(1)
    @DisplayName("Test input.")
    void testInput() {
      final Input input = factory.createInput();
      assertInstanceOf(Input.class, input);
      assertInstanceOf(WindowsInput.class, input);
    }

    @Test
    @Order(2)
    @DisplayName("Test button.")
    void testButton() {
      final Button button = factory.createButton();
      assertInstanceOf(Button.class, button);
      assertInstanceOf(WindowsButton.class, button);
    }

    @Test
    @Order(3)
    @DisplayName("Test checkbox.")
    void testCheckbox() {
      final Checkbox checkbox = factory.createCheckbox();
      assertInstanceOf(Checkbox.class, checkbox);
      assertInstanceOf(WindowsCheckbox.class, checkbox);
    }
  }

  @Nested
  @Order(1)
  @DisplayName("Test MacOS.")
  class TestMacOS {

    @BeforeEach
    void setup() {
      factory = GUIApplication.getGUIFactory(OSTypes.MACOS);
    }

    @Test
    @Order(1)
    @DisplayName("Test input.")
    void testInput() {
      final Input input = factory.createInput();
      assertInstanceOf(Input.class, input);
      assertInstanceOf(MacOSInput.class, input);
    }

    @Test
    @Order(2)
    @DisplayName("Test button.")
    void testButton() {
      final Button button = factory.createButton();
      assertInstanceOf(Button.class, button);
      assertInstanceOf(MacOSButton.class, button);
    }

    @Test
    @Order(3)
    @DisplayName("Test checkbox.")
    void testCheckbox() {
      final Checkbox checkbox = factory.createCheckbox();
      assertInstanceOf(Checkbox.class, checkbox);
      assertInstanceOf(MacOSCheckbox.class, checkbox);
    }
  }
}
