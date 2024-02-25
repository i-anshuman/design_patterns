package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Person implements PersonPrototype {
  private String name;
  private int age;
  private String address;
  private List<String> hobbies;

  public Person(String name, int age, String address, List<String> hobbies) {
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
  public Person copy() {
    return new Person(this.name, this.age, this.address, new ArrayList<>(hobbies));
  }
}
