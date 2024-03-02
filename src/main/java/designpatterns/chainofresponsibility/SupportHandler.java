package designpatterns.chainofresponsibility;

public interface SupportHandler {
  void handleRequest(Request request);
  void nextHandler(SupportHandler handler);
}
