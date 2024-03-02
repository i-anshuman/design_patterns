package designpatterns.chainofresponsibility;

public class Request {
  private final RequestType type;
  private final String query;

  public Request(RequestType type, String query) {
    this.type = type;
    this.query = query;
  }

  public RequestType getType() {
    return type;
  }

  public String getQuery() {
    return query;
  }
}
