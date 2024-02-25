package designpatterns.builder;

public class Person {
  private final String name;
  private final Integer age;
  private final String gender;
  private final String address;

  public Person(String name, Integer age, String gender, String address) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getGender() {
    return gender;
  }

  public String getAddress() {
    return address;
  }
}
