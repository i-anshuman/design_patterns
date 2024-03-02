# Chain of Responsibility Design Pattern

## Category

Chain of Responsibility design pattern falls under category of **Behavioral Design Pattern**.

---

## Problem

This pattern decouples the sender of a request from its receiver, giving multiple objects the opportunity to handle the request. The request is passed along the chain until it is handled or reaches the end of the chain.

The Chain of Responsibility pattern solves the following problems:

1. **Decouples request senders and receivers**: The pattern decouples objects that send requests from objects that handle requests, allowing them to vary independently. Senders don't need to know which specific handler will process their request, and receivers don't need to know where the request originated.

2. **Allows for dynamic handling**: Handlers can be added, removed, or reordered dynamically without affecting the client code. This flexibility makes the pattern suitable for scenarios where the handling logic may change or vary at runtime.

3. **Reduces code duplication**: Instead of having multiple conditional statements in the client code to determine which object should handle a request, the pattern encapsulates the decision-making process within the handlers. This leads to cleaner and more maintainable code.

4. **Supports open/closed principle**: The pattern supports the open/closed principle by allowing new handlers to be added without modifying existing client code.

> Overall, the **Chain of Responsibility** pattern is useful in scenarios where there are multiple objects that can handle a request, and the exact handler isn't known at compile time. It promotes flexibility, maintainability, and separation of concerns in software design.

---

## Example

Imagine a customer support system for an e-commerce platform that sells electronic products. Customers may encounter various issues or inquiries related to their purchases, such as technical problems, billing inquiries, product feedback, and general support questions. The customer support system needs to efficiently route these requests to the appropriate departments or teams for resolution.

---

## Implementation

1. **Create Handler Interface**: It represents the base interface for handling or delegate customer requests.
    ```java
    public interface SupportHandler {
      void handleRequest(Request request);
      void nextHandler(SupportHandler handler);
    }
    ```

2. **Create Default Handler**: Create an `abstract` class by implementing `SupportHandler` and provide implementation for `nextHandler` method so that all concrete handler can use this to create responsibility chain. 
    ```java
    public abstract class DefaultSupportHandler implements SupportHandler {
      protected SupportHandler next;
    
      @Override
      public void nextHandler(SupportHandler handler) {
        this.next = handler;
      }
    }
    ```

3. **Define `RequestType` Enum**: It defines the type of request as `enum` provides an efficient way to define a set of named integral constants that may be assigned to a variable and compare them.
    ```java
    public enum RequestType {
      TECHNICAL, BILLING, PRODUCT, GENERAL, COMPLAINT
    }
    ```

4. **Create Custom `Request` class**: This class represents a customer request with details such as the type of request.
   ```java
   public class Request {
     private final RequestType type;
     private final String query;
   
     public Request(RequestType type, String query) {
       this.type = type;
       this.query = query;
     }
   
     // Getters
   }
   ```

5. **Implement Concrete `SupportHandler`**: Implement different concrete handler for handling specific types of customer requests.
    ```java
    public class BillingSupportHandler extends DefaultSupportHandler {
      @Override
      public void handleRequest(Request request) {
        if(request.getType().equals(TicketType.BILLING)) {
          log.info("Billing support.");
        }
        else {
          this.next.handleRequest(request);
        }
      }
    }
    
    public class ProductSupportHandler extends DefaultSupportHandler {
      @Override
      public void handleRequest(Request request) {
        if(request.getType().equals(TicketType.PRODUCT)) {
          log.info("Product support.");
        }
        else {
          this.next.handleRequest(request);
        }
      }
    }
    
    public class TechnicalSupportHandler extends DefaultSupportHandler {
      @Override
      public void handleRequest(Request request) {
        if(request.getType().equals(TicketType.TECHNICAL)) {
          log.info("Technical support.");
        }
        else {
          this.next.handleRequest(request);
        }
      }
    }
    
    public class GeneralSupportHandler extends DefaultSupportHandler {
      @Override
      public void handleRequest(Request request) {
        if(request.getType().equals(TicketType.GENERAL)) {
          log.info("General support.");
        }
        else {
          this.next.handleRequest(request);
        }
      }
    }
   
    // Fallback handler
    public class NoSupportHandler extends DefaultSupportHandler {
      @Override
      public void handleRequest(Request request) {
        log.info("No support handler.");
      }
    }
    ```

6. **Create a utility class to create chain of handlers**: This is a helper class that create a handler chain from a list of handlers.
   ```java
   public class SupportHandlerChain {
   
     private SupportHandlerChain() {}
   
     public static SupportHandler getDefaultChain() {
       SupportHandler billing   = new BillingSupportHandler();
       SupportHandler product   = new ProductSupportHandler();
       SupportHandler technical = new TechnicalSupportHandler();
       SupportHandler general   = new GeneralSupportHandler();
       SupportHandler fallback  = new NoSupportHandler();

       billing.nextHandler(product);
       product.nextHandler(technical);
       technical.nextHandler(general);
       general.nextHandler(fallback);
       return billing;
     }
   }
   ```

7. **Client code**: The client initiates customer requests and submits them to the request chain.

   ```java
   import designpatterns.chainofresponsibility.SupportHandler;
   import designpatterns.chainofresponsibility.SupportHandlerChain;
   
   public static void main(String[] args) {
      SupportHandler handler = SupportHandlerChain.getDefaultChain();
      handler.handleRequest(new Request(RequestType.BILLING, "Refund not initiated."));
      handler.handleRequest(new Request(RequestType.TECHNICAL, "Unable to login."));
      handler.handleRequest(new Request(RequestType.PRODUCT, "Discount on Product."));
      handler.handleRequest(new Request(RequestType.GENERAL, "Coupon expiration duration."));
      handler.handleRequest(new Request(RequestType.COMPLAINT, "Delay in delivery."));
   }
   ```

> Overall, the Chain of Responsibility pattern promotes loose coupling and flexibility in handling requests by forming a dynamic chain of handler objects, making it a valuable tool for building extensible and maintainable software systems.