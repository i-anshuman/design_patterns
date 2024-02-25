package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {

  private String name;
  private int age;
  private String address;

  private List<String> hobbies;

  public Employee(String name, int age, String address, List<String> hobbies) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.hobbies = hobbies;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getAddress() {
    return address;
  }

  public List<String> getHobbies() {
    return hobbies;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setHobbies(List<String> hobbies) {
    this.hobbies = hobbies;
  }

  public void addHobby(String hobby) {
    this.hobbies.add(hobby);
  }

  @Override
  public Employee clone() {
    try {
      Employee person = (Employee) super.clone();
      person.setHobbies(new ArrayList<>(this.hobbies)); // Deep copy the reference type.
      return person;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
