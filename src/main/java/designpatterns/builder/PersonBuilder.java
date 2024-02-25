package designpatterns.builder;

public interface PersonBuilder {
  PersonBuilder setName(String name);
  PersonBuilder setAge(Integer age);
  PersonBuilder setGender(String gender);
  PersonBuilder setAddress(String address);
  Person build();
}
