package designpatterns.chainofresponsibility;

import java.util.List;

public class SupportHandlerChain {

  private SupportHandlerChain() {}

  public static SupportHandler createChain(List<SupportHandler> handlers) {
    final SupportHandler chain = handlers.stream().reduce((prev, current) -> {
                                    prev.nextHandler(current);
                                    return current;
                                  }).orElse(new NoSupportHandler());
    if(!(chain instanceof NoSupportHandler)) {
      chain.nextHandler(new NoSupportHandler());
    }
    return handlers.get(0);
  }

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
