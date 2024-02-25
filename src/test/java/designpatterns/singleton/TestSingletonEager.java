package designpatterns.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("Test eager implementation of single design pattern.")
@Tags({
  @Tag("Singleton design pattern.")
})
class TestSingletonEager {

  @Test
  @DisplayName("Test base case.")
  void case1() {
    final SingletonEager instance1 = SingletonEager.getInstance();
    final SingletonEager instance2 = SingletonEager.getInstance();
    assertSame(instance1, instance2);
    assertEquals(instance1.hashCode(), instance2.hashCode());
  }
}
