package javafeatures.lambda;

import java.util.List;

public class LambdaTutorial {

    @FunctionalInterface
    interface CheckPerson {
        boolean test(Person p);
    }

    static class CheckPersonWithinAgeRange implements CheckPerson {
        @Override
        public boolean test(Person p) {
            return p.getAge() > 20 && p.getAge() < 40;
        }
    }
    public static void printPeople(List<Person> people, CheckPerson function){
        for(Person p:people){
            if(function.test(p))
                p.printPerson();
        }
    }
    public static void main(String[] args) {
        List<Person> people = Person.generateStaticList();

        System.out.println("---- Passing Functional Interface ----");
        printPeople(people, new CheckPersonWithinAgeRange());

        System.out.println("---- Passing Functional Interface as Inline Function ----");
        printPeople(people, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getAge() > 20 && p.getAge() < 40;
            }
        });

        System.out.println("---- Passing Functional Interface as Lambda Expression ----");
        printPeople(people, (Person p) -> {
                return p.getAge() > 20 && p.getAge() < 40;
            }
        );

        System.out.println("---- Passing Functional Interface as Lambda Expression ----");
        printPeople(people, p ->  p.getAge() > 20 && p.getAge() < 40);

        System.out.println("---- Passing Functional Interface as Lambda Expression ----");
        printPeople(people, p -> p.getEmail().contains("gmail"));
    }
}
