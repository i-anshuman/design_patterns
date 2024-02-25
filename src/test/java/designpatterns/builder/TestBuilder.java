package designpatterns.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tags({ @Tag("Creation"), @Tag("Builder") })
@DisplayName("Test builder pattern.")
class TestBuilder {

  private PersonBuilder builder;

  @BeforeEach
  void setup() {
    builder = new BasicPersonBuilder();
  }

  @Test
  void case1() {
    final Person person = builder.setName("Anshuman").build();
    assertEquals("Anshuman", person.getName());
    assertEquals(0, person.getAge());
    assertNull(person.getGender());
    assertNull(person.getAddress());
  }

  @Test
  void case2() {
    final Person person = builder.setName("Anshuman").setAge(26).build();
    assertEquals("Anshuman", person.getName());
    assertEquals(26, person.getAge());
    assertNull(person.getAddress());
    assertNull(person.getGender());
  }

  @Test
  void case3() {
    final Person person = builder.setName("Anshuman").setAge(26).setGender("M").setAddress("Pune").build();
    assertEquals("Anshuman", person.getName());
    assertEquals(26, person.getAge());
    assertEquals("M", person.getGender());
    assertEquals("Pune", person.getAddress());
  }

  @Test
  void case4() {
    final Person person = builder.build();
    assertNull(person.getName());
    assertEquals(0, person.getAge());
    assertNull(person.getGender());
    assertNull(person.getAddress());
  }
}
