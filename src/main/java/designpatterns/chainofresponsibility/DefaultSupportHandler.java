package designpatterns.chainofresponsibility;

public abstract class DefaultSupportHandler implements SupportHandler {
  protected SupportHandler next;

  @Override
  public void nextHandler(SupportHandler handler) {
    this.next = handler;
  }
}
