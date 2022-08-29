package javafeatures.lambda;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public enum Sex {MALE, FEMALE}
    private String name;
    private int age;
    private Sex gender;
    private String email;

    public Person() {
    }

    public Person(String name, int age, Sex gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
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

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    public void printPerson(){
        System.out.println(this.toString());
    }

    public static List<Person> generateStaticList(){
        List<Person> people = new ArrayList<>();
        
        people.add(new Person("Hiren",40,Sex.MALE,"hiren@gmail.com"));
        people.add(new Person("Kosha",37,Sex.FEMALE,"kosha@gmail.com"));
        people.add(new Person("Jwal",11,Sex.MALE,"jwal@gmail.com"));
        return people;
    }
}
