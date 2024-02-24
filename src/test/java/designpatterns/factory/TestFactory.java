package designpatterns.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tags({ @Tag("Creation"), @Tag("Factory") })
@DisplayName("Test factory design pattern.")
class TestFactory {

  @Test
  @DisplayName("Test report.")
  void testReport() {
    final Document report = DocumentFactory.getDocument(DocumentTypes.REPORT);
    assertInstanceOf(Report.class, report);
  }

  @Test
  @DisplayName("Test spreadsheet.")
  void testSpreadsheet() {
    final Document spreadsheet = DocumentFactory.getDocument(DocumentTypes.SPREADSHEET);
    assertInstanceOf(SpreadSheet.class, spreadsheet);
  }

  @Test
  @DisplayName("Test presentation.")
  void testPresentation() {
    final Document presentation = DocumentFactory.getDocument(DocumentTypes.PRESENTATION);
    assertInstanceOf(Presentation.class, presentation);
  }
}
