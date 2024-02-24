package designpatterns.factory;

public class DocumentFactory {

  private DocumentFactory() {}

  public static Document getDocument(DocumentTypes type) {
    return switch (type) {
      case REPORT -> new Report();
      case SPREADSHEET -> new SpreadSheet();
      case PRESENTATION -> new Presentation();
    };
  }
}
