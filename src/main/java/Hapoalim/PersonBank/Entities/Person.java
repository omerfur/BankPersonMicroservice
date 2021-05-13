package Hapoalim.PersonBank.Entities;


import Hapoalim.PersonBank.Entities.enums.Gender;

public class Person {


    private String id;
    private String name;
    private int age;

    private Gender gender;

    private double hight;
    private double weight;
    private Address address;

    public Person() {
    }

    public Person(String id, String name, int age, Gender gender, double hight, double weight, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hight = hight;
        this.weight = weight;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hight=" + hight +
                ", weight=" + weight +
                ", address=" + address +
                '}';
    }
}

