package com.streams;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Akhil", 45000, "IT"),
                new Employee(2, "John", 60000, "IT"),
                new Employee(3, "David", 55000, "Finance"),
                new Employee(4, "Lisa", 75000, "Finance"),
                new Employee(5, "Mark", 50000, "HR"),
                new Employee(6, "Sophie", 72000, "IT"),
                new Employee(7, "Robert", 68000, "HR"),
                new Employee(8, "Emma", 82000, "Finance"),
                new Employee(9, "Daniel", 48000, "HR"),
                new Employee(10, "Chris", 90000, "IT"),
                new Employee(11, "Olivia", 65000, "Marketing"),
                new Employee(12, "Liam", 70000, "Marketing"),
                new Employee(13, "Noah", 58000, "Sales"),
                new Employee(14, "Ava", 62000, "Sales")
        );
//        1. Get all employees from IT department
        System.out.println("Employees from IT department:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .forEach(System.out::println);
//        2. Find all employees from IT who have salary >60000.

        System.out.println("Employees from Sales with salary > 60000:");

        employees.stream().filter(e -> e.getDepartment().equals("Sales") && e.getSalary() > 50000)
                .forEach(System.out::println);

//       3. Find employees whose names start with "A".
        System.out.println("Employees whose names start with 'A':");
        employees.stream().filter(e -> e.getName().startsWith("A")).forEach(System.out::println);

//        4. Get employees from HR or Finance department.
        System.out.println("Employees from HR or Finance department:");
        employees.stream().filter(e->e.getDepartment().equals("HR") || e.getDepartment().equals("Finance"))
        .forEach(System.out::println);

//        5. Find employees with salary between 60000 and 100000.
        System.out.println("Employees with salary between 60000 and 100000:");
        employees.stream().filter(e -> e.getSalary() > 60000 && e.getSalary() < 100000)
                .forEach(System.out::println);


//        6. Get a list of all employee names.
        System.out.println("List of all employee names:");
        List<String> names = employees.stream().map(Employee::getName).toList();
        System.out.println("List of employee names: " + names);

//        7.Count employees in each department
        System.out.println("Count of employees in each department:");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
               .forEach((dept, count) -> System.out.println(dept + ": " + count));

//        8. Find the maximum salary among all employees.
        System.out.println("Finding maximum salary among all employees:");
        employees.stream().mapToDouble(Employee::getSalary).max().ifPresent(maxSalary ->
                System.out.println("Maximum salary among all employees: " + maxSalary));

//        9. Find the lowest highest salary among all employees.
        System.out.println("Finding lowest salary among all employees:");
        employees.stream().mapToDouble(Employee::getSalary).min()
                .ifPresent(lowestSalary -> System.out.println("Second highest salary is: " + lowestSalary));

//        10. second-highest salary among all employees.
        System.out.println("Finding second highest salary among all employees:");
       employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()
               .ifPresent(secondHighestSalary -> System.out.println("Second highest salary is: " + secondHighestSalary));

//        11. Get the employee with the highest salary in each department.
        System.out.println("Employee with highest salary in each department:");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))
         ).forEach((dept, emp) -> emp.ifPresent(employee -> System.out.println(dept + ": " + employee)));


//       12. Calculate the average salary of all employees.
        System.out.println("Average salary of all employees:");
        Double collect = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect);

//       13. Calculate the average salary in each department.
        System.out.println("Average salary in each department:");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((dept, avgSalary) -> System.out.println(dept + ": " + avgSalary));

//       14. Get the total salary expenditure for each department.
        System.out.println("Total salary expenditure for each department:");
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
                .forEach((dept, totalSalary) -> System.out.println(dept + ": " + totalSalary));

//       15. Group employees by their department.
        System.out.println("Employees grouped by their department:");
        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect1);

//       16. Sort employees by their department names in reverse order.
        System.out.println("Employees sorted by their department names in reverse order:");
        Map<String, List<Employee>> collect2 = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment).reversed())
                .collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.toList()));
        System.out.println(collect2);

//       17. Find all employees with salary greater than 60000.
        System.out.println("employees with salary greater than 60000");
        employees.stream().filter(e->e.getSalary()>60000).forEach(System.out::println);

//        18. Sort employees by salary ascending
        System.out.println("employees by salary ascending");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

//        19. Sort employees by salary descending
        System.out.println("employees by salary descending");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);


//        20. Sort employees by department and then by salary ascending
        System.out.println("employees by department and then by salary ascending");
   employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).forEach(System.out::println);

//        21. Get the top 3 highest paid employees.
        System.out.println("top 3 highest paid employees");
   employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);

//        22. Create a map of employee ID to employee object.
        System.out.println("map of employee ID to employee object");
        Map<Integer, Employee> collect3 = employees.stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
        System.out.println(collect3);

//        23. Create a map of department to list of employee names in that department.
        System.out.println("map of department to list of employee names in that department");
       Map<String, List<String>> collect4 =
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        System.out.println(collect4);

//        24. Get a list of distinct departments.
        System.out.println("list of distinct departments");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

//        25. Create a list of employee names in uppercase.
        System.out.println("list of employee names in uppercase");
        List<String> list = employees.stream().map(e -> e.getName().toUpperCase()).toList();
        System.out.println(list);

//        26. Join all employee names into a single string separated by commas.
        System.out.println("Joining all employee names into a single string separated by commas:");
        String collect5 = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println("All employee names joined: " + collect5);

//        27. Check if any employee is from the HR department.
        System.out.println("Checking if any employee is from the HR department:");
        employees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .findAny().ifPresent(dept -> System.out.println("There is at least one employee from HR department: " + dept));

//        28. Check if any employee who earns more than 80k
        System.out.println("Checking if any employee earning more than 80k");
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 80000);
        System.out.println("Any employee earning more than 80k: " + b1);

//        29. Check if all employees earn more than 30000
        System.out.println("Checking if all employees earn more than 30000:");
        boolean b = employees.stream().allMatch(e -> e.getSalary() > 30000);
        System.out.println("All employees earning more than 30000: " + b);

//        30. Check if no employees are from the Legal department.
        System.out.println("Checking if no employees are from the Legal department:");
        boolean legal = employees.stream().noneMatch(e -> e.getDepartment().equals("Legal"));
        System.out.println("No employees in Legal department: " + legal);

//        31. Get First Employee in sorted salary list
        System.out.println("First Employee in sorted salary list:");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst()
                .ifPresent(emp -> System.out.println("First employee in sorted salary list"+ emp));

//        32. Get Second Highest paid employee
        System.out.println("Second highest paid employee:");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1).findFirst().ifPresent(emp -> System.out.println("Second highest paid employee: " + emp));

//        33. Get Highest paid employee in IT department
        System.out.println("Highest paid employee in IT department:");
        employees.stream().filter(e-> e.getDepartment().equals("IT"))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst().ifPresent(emp -> System.out.println("Highest paid employee in IT department: " + emp));


//        34. Get the department with the highest average salary.
        System.out.println("Department with highest average salary:");
        Optional<Map.Entry<String, Double>> max = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(max);

        Map<Boolean, List<Employee>> collect6 = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        for(Map.Entry<Boolean, List<Employee>> entry : collect6.entrySet()){
            if(entry.getKey()){
                System.out.println("Employees with salary greater than 60000: " + entry.getValue());
            } else {
                System.out.println("Employees with salary less than or equal to 60000: " + entry.getValue());
            }
        }


    }
}