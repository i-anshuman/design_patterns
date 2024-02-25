package designpatterns.builder;

public class BasicPersonBuilder implements PersonBuilder {
  private String name;
  private int age;
  private String gender;
  private String address;

  @Override
  public PersonBuilder setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PersonBuilder setAge(Integer age) {
    this.age = age;
    return this;
  }

  @Override
  public PersonBuilder setGender(String gender) {
    this.gender = gender;
    return this;
  }

  @Override
  public PersonBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  @Override
  public Person build() {
    return new Person(name, age, gender, address);
  }
}
