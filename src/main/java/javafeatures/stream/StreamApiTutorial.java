package javafeatures.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTutorial {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Hiren", "Shah", 4000.00, List.of("Project1", "Project2")));
        employeeList.add(new Employee("Kosha", "Shah", 5000.00, List.of("Project3", "Project4")));
        employeeList.add(new Employee("Jwal", "Shah", 6000.00, List.of("Project1", "Project3")));

        //stream
        employeeList.stream()
                        .forEach(employee -> System.out.println(employee));
        //map
        //collect
        System.out.println("-------------- MAP and COLLECT ------------------");
        employeeList.stream()
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() * 1.10,
                        employee.getProjects()
                ))
                .collect(Collectors.toList())
                .forEach(employee -> System.out.println(employee));


        //filter
        System.out.println("-------------- FILTER ------------------");
        employeeList.stream()
                .filter(employee -> employee.getSalary() >= 5000)
                .map(employee -> new Employee(employee.getFirstName(), employee.getLastName(), employee.getSalary() *1.1, employee.getProjects()))
                .collect(Collectors.toList())
                .forEach(employee -> System.out.println(employee));


        //filter and findFirst
        System.out.println("-------------- FILTER and FINDFIRST------------------");
        Employee employee1 = employeeList.stream()
                .filter(employee -> employee.getSalary() >= 5000)
                .map(employee -> new Employee(employee.getFirstName(), employee.getLastName(), employee.getSalary() * 1.1, employee.getProjects()))
                .findFirst()
                .orElse(null);
        System.out.println(employee1);

        //filter and findFirst
        System.out.println("-------------- FLATMAP ------------------");
        String projectDetails = employeeList.stream()
            //    .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> employee.getProjects())
                .flatMap(projects -> projects.stream())
                .collect(Collectors.joining(","));

        System.out.println(projectDetails);

        System.out.println("-------------- Short Circuit  ------------------");
        employeeList.stream().skip(1).limit(2).forEach(employee -> System.out.println(employee));


        System.out.println("-------------- Finite  ------------------");
        Stream.generate(Math::random)
                        .limit(4)
                                .forEach(value -> System.out.println(value));

        System.out.println("-------------- Sorted  ------------------");
        employeeList.stream()
                .sorted((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()) )
                .collect(Collectors.toList())
                .forEach(employee -> System.out.println(employee));


        System.out.println("-------------- Min / Max  ------------------");
        Employee employee2 = employeeList.stream()
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(employee2);

        System.out.println("-------------- Reduce  ------------------");
        Double totalSalary = employeeList.stream()
                .map(employee -> employee.getSalary()) // Map to Stream of Salary attribute of Employee Object
                .filter(salary -> salary >=5000 ) // Filters Salary Greater Than
                .reduce(0.0, Double::sum);  // Addition of only filtered records
        System.out.println(totalSalary);
    }
}
