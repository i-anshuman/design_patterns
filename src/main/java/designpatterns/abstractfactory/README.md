# Abstract Factory Design Pattern

## Category

Abstract Factory design pattern falls under category of **Creational Design Pattern**.

---

## Problem

The Abstract Factory Design Pattern solves the problem of creating families of related or dependent objects without specifying their concrete classes. It addresses scenarios where an application needs to create multiple related objects that have varying implementations based on a certain theme or context.

Here's a breakdown of the problems it solves:

1. **Decoupling Object Creation**: In many applications, object creation is tightly coupled with the client code, meaning the client code directly instantiates concrete classes of objects. This can lead to inflexible code that is difficult to maintain and extend because any change in the concrete classes requires modifications to the client code.

2. **Creating Families of Related Objects**: Sometimes, an application needs to create families of related objects, where the objects within a family are designed to work together or have some common theme. For example, in a GUI application, different types of UI elements (buttons, checkboxes) need to be consistent with a specific look and feel (e.g., Windows, macOS).

3. **Supporting Multiple Variants or Themes**: Applications often need to support multiple variants or themes, where each variant may have its own set of related objects with different implementations. For instance, in a GUI application, different levels OS may require different implementation of UI elements.

4. **Encapsulating Object Creation Logic**: The Abstract Factory Pattern encapsulates the creation logic of related objects within factory interfaces, promoting separation of concerns and encapsulation. This allows for easier maintenance and modification of the object creation logic without affecting the client code.

> Overall, the Abstract Factory Pattern provides a way to create families of related objects with varying implementations while decoupling the client code from the specific classes of objects being created. It promotes flexibility, scalability, and maintainability in the design of object-oriented systems by encapsulating object creation logic and allowing for easy switching between different families of objects.

---

## Example

Suppose you are developing a GUI application that needs to support multiple platforms, such as Windows and macOS, with their respective look and feel. Each platform has its own set of UI components, such as inputs, buttons and checkboxes, that need to be created consistently across the application. Each component has it's own rendering logic depending on the platform.

---

## Implementation

1. **Abstract Product Interfaces**: Define abstract product interfaces for UI components that represent the common behavior of buttons and checkboxes.

    ```java
    interface Input {
      void render();
    }
    
    interface Button {
      void render();
    }
    
    interface Checkbox {
      void render();
    }
    ```

2. **Concrete Product Implementations**: Implement concrete product classes for UI components specific to each platform (e.g., Windows and macOS).

    ```java
    class WindowsInput implements Input {
      @Override
      public void render() {
        System.out.println("Rendering Windows input");
      }
    }
   
    class WindowsButton implements Button {
      @Override
      public void render() {
        System.out.println("Rendering Windows button");
      }
    }
    
    class WindowsCheckbox implements Checkbox {
      @Override
      public void render() {
        System.out.println("Rendering Windows checkbox");
      }
    }
   
    class MacOSInput implements Input {
      @Override
      public void render() {
        System.out.println("Rendering MacOS input");
      }
    }
    
    class MacOSButton implements Button {
      @Override
      public void render() {
        System.out.println("Rendering MacOS button");
      }
    }
    
    class MacOSCheckbox implements Checkbox {
      @Override
      public void render() {
        System.out.println("Rendering MacOS checkbox");
      }
    }
    ```

3. **Abstract Factory Interface**: Define an abstract factory interface `GUIFactory` for creating families of related UI components.

    ```java
    interface GUIFactory {
      Input createInput();
      Button createButton();
      Checkbox createCheckbox();
    }
    ```

4. **Concrete Factory Implementations**: Implement concrete factory classes for each platform, which create families of related UI components specific to that platform.

    ```java
    class WindowsGUIFactory implements GUIFactory {
      @Override
      public Input createInput() {
        return new WindowsInput();
      }
   
      @Override
      public Button createButton() {
        return new WindowsButton();
      }
      
      @Override
      public Checkbox createCheckbox() {
        return new WindowsCheckbox();
      }
    }
    
    class MacOSGUIFactory implements GUIFactory {
      @Override
      public Input createInput() {
        return new MacOSInput();
      }
   
      @Override
      public Button createButton() {
        return new MacOSButton();
      }
      
      @Override
      public Checkbox createCheckbox() {
        return new MacOSCheckbox();
      }
    }
    ```

5. **Client Code**: Use the concrete factory to create families of related UI components for a specific platform.

    ```java
    public class GUIApplication {
      private final GUIFactory guiFactory;
      
      public GUIApplication(GUIFactory guiFactory) {
        this.guiFactory = guiFactory;
      }
      
      public void createUI() {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.render();
        checkbox.render();
      }
      
      public static void main(String[] args) {
        // Create GUI application for Windows
        GUIApplication windowsApp = new GUIApplication(new WindowsGUIFactory());
        windowsApp.createUI();
        // Create GUI application for macOS
        GUIApplication macApp = new GUIApplication(new MacOSGUIFactory());
        macApp.createUI();
      }
    }
    ```

> Overall abstract factory design pattern make it easy to manage and modify component logic and adding new platform without affecting client code.
