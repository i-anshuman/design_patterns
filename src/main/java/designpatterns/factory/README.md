# Factory Design Pattern

## Category

Factory design pattern falls under category of **Creational Design Pattern**.

---

## Problem

The Factory Design Pattern addresses the problem of creating objects without exposing the instantiation logic to the
client code. It provides a way to create objects through a common interface or superclass, hiding the implementation
details of the object creation process.

The breakdown of the problem the Factory Pattern solves:

- **Decoupling Object Creation**: Separating object creation logic from rest of code.
- **Complex Object Creation Logic**: Sometimes, object creation involves complex logic based certain configuration. It
  can be error-prone and difficult to manage if scattered throughout the client code.
- **Abstraction of Object Creation**: Allow to create objects through a common interface or method without needing to
  know the specific class of the objects being created.
- **Flexibility and Extensibility**: Easy modification and extension without affecting the client code.

---

## Example

Consider a real-life example of a Factory Pattern used in a software application for creating different types of
documents.

You're tasked with developing a document processing application where users can create various types of documents, such
as reports, spreadsheets, and presentations. Each type of document requires different creation and processing logic. As
the application evolves, new document types may be added.

---

## Implementation

1. **Document Interface**: We start by defining a `Document` interface that outlines common operations that all
   documents must support. This interface ensures that each document type adheres to a consistent set of behaviors.

    ```java
    public interface Document {
      void open();
      void save();
      void close();
    }
    ```

2. **Concrete Document Classes**: Next, we create concrete document classes that implement the `Document` interface.
   Each class represents a specific type of document (
   e.g., `ReportDocument`, `SpreadsheetDocument`, `PresentationDocument`). These classes encapsulate the specific
   behavior and logic associated with their respective document types.

    ```java
    public class ReportDocument implements Document {
      // Implementation of open(), save(), close() methods specific to report documents
    }
    
    public class SpreadsheetDocument implements Document {
      // Implementation of open(), save(), close() methods specific to spreadsheet documents
    }
    
    public class PresentationDocument implements Document {
      // Implementation of open(), save(), close() methods specific to presentation documents
    }
    ```

3. **Document Factory**: We introduce a `DocumentFactory` class responsible for creating instances of different document
   types. The factory method in this class abstracts the document creation process, allowing the client code to create
   documents without knowing the specific implementation details of each document type.

    ```java
    public class DocumentFactory {
      public static Document createDocument(String type) {
        return switch (type.toLowerCase()) {
          case "report" -> new ReportDocument();
          case "spreadsheet" -> new SpreadsheetDocument();
          case "presentation" -> new PresentationDocument();
          default -> throw new IllegalArgumentException("Invalid document type: " + type);
        };
      }
    }
    ```

4. **Client Code**: Finally, in the client code (e.g., the main application), we utilize the `DocumentFactory` to create
   instances of various document types. The client code remains decoupled from the specific document classes, as it only
   interacts with the factory interface.

    ```java
    public class DocumentProcessingApp {
      public static void main(String[] args) {
        Document reportDocument = DocumentFactory.createDocument("report");
        Document spreadsheetDocument = DocumentFactory.createDocument("spreadsheet");
        Document presentationDocument = DocumentFactory.createDocument("presentation");
    
        // Perform operations on documents (e.g., open, save, close)
      }
    }
    ```

## Key Benefits of Factory Pattern in this Example:

- **Abstraction**: The Factory Pattern abstracts the document creation process, allowing clients to create documents
  without knowing their specific types.
- **Encapsulation**: Concrete document classes encapsulate the unique behavior and logic of each document type,
  promoting separation of concerns.
- **Flexibility**: Adding new document types (e.g., `EmailDocument`, `ContractDocument`) is straightforward, as the
  creation logic is centralized in the `DocumentFactory` class.
- **Loose Coupling**: The client code is loosely coupled with the concrete document classes, reducing dependencies and
  enhancing maintainability.

> Overall, the Factory Pattern facilitates the creation of flexible and maintainable document processing applications by encapsulating object creation logic and promoting abstraction and loose coupling between components.