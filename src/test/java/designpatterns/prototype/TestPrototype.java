package designpatterns.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tags({ @Tag("Creation"), @Tag("Prototype") })
@DisplayName("Test prototype pattern.")
class TestPrototype {


  @Nested
  @Order(1)
  @DisplayName("Test prototype without cloneable.")
  class TestWithoutCloneable {
    private Person person;

    @BeforeEach
    void setup() {
      List<String> hobbies = new ArrayList<>();
      hobbies.add("Movies");
      hobbies.add("Photography");
      person = new Person("Anshuman", 26, "Pune", hobbies);
    }

    @Test
    void case1() {
      final Person personCopy = person.copy();
      personCopy.setAge(27);
      personCopy.setAddress("Pashan");
      personCopy.addHobby("Music");

      assertEquals(person.getName(), personCopy.getName());
      assertNotEquals(person.getAge(), personCopy.getAge());
      assertNotEquals(person.getAddress(), personCopy.getAddress());
      assertFalse(Arrays.equals(person.getHobbies().toArray(), personCopy.getHobbies().toArray()));
    }
  }

  @Nested
  @Order(1)
  @DisplayName("Test prototype with cloneable.")
  class TestWithCloneable {
    private Employee employee;

    @BeforeEach
    void setup() {
      List<String> hobbies = new ArrayList<>();
      hobbies.add("Movies");
      hobbies.add("Photography");
      employee = new Employee("Anshuman", 26, "Pune", hobbies);
    }

    @Test
    void case1() {
      final Employee personCopy = employee.clone();
      personCopy.setAge(27);
      personCopy.setAddress("Pashan");
      personCopy.addHobby("Music");

      assertEquals(employee.getName(), personCopy.getName());
      assertNotEquals(employee.getAge(), personCopy.getAge());
      assertNotEquals(employee.getAddress(), personCopy.getAddress());
      assertFalse(Arrays.equals(employee.getHobbies().toArray(), personCopy.getHobbies().toArray()));
    }
  }
}
