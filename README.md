# Java 8 Streams Coding Practice

This repository contains **Java 8 Stream API coding examples and practice problems** implemented using a sample `Employee` dataset.
The goal of this project is to **understand functional programming concepts introduced in Java 8**, including streams, lambda expressions, and collectors.

This project is useful for:

* Java developers preparing for **technical interviews**
* Practicing **Java 8 Stream operations**
* Understanding **functional-style programming in Java**

---

## Tech Stack

* Java 8+
* Stream API
* Collections Framework
* IntelliJ IDEA / Eclipse

---

## Project Structure

```
java8-streams-coding
│
├── src
│   └── com.streams
│        ├── Employee.java
│        └── Main.java
│
└── README.md
```

* **Employee.java** → Model class representing employee details
* **Main.java** → Contains multiple Java 8 Stream operations and coding examples

---

## Employee Dataset

The program uses a sample list of employees with attributes:

* `id`
* `name`
* `salary`
* `department`

Example:

```java
new Employee(1, "Akhil", 45000, "IT")
new Employee(2, "John", 60000, "IT")
new Employee(3, "David", 55000, "Finance")
```

---

## Stream Operations Covered

This project demonstrates various **real-world Stream API operations** such as:

### Filtering

* Employees from a specific department
* Employees with salary greater than a threshold
* Employees whose names start with a particular letter

Example:

```java
employees.stream()
        .filter(e -> e.getDepartment().equals("IT"))
        .forEach(System.out::println);
```

---

### Mapping

Transform employee objects into another form.

Examples:

* Extract employee names
* Convert names to uppercase

```java
List<String> names =
employees.stream()
        .map(Employee::getName)
        .toList();
```

---

### Sorting

Sorting employees based on different attributes.

Examples:

* Salary ascending
* Salary descending
* Department then salary

```java
employees.stream()
        .sorted(Comparator.comparing(Employee::getSalary))
        .forEach(System.out::println);
```

---

### Aggregation Operations

Examples:

* Maximum salary
* Minimum salary
* Average salary
* Total salary

```java
employees.stream()
        .mapToDouble(Employee::getSalary)
        .max();
```

---

### Grouping

Group employees based on departments.

```java
employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));
```

Examples implemented:

* Count employees per department
* Average salary per department
* Highest salary per department
* Total salary per department

---

### Partitioning

Partition employees into two groups based on salary.

```java
Collectors.partitioningBy(e -> e.getSalary() > 60000)
```

---

### Reduce Operations

Examples using `reduce()`:

* Calculate total salary
* Find employee with longest name

```java
employees.stream()
        .map(Employee::getSalary)
        .reduce(0.0, Double::sum);
```

---

### Matching Operations

Examples:

* `anyMatch`
* `allMatch`
* `noneMatch`

Used to check conditions on employees.

---

### Advanced Operations

Examples implemented:

* Second highest salary
* Top 3 highest paid employees
* Highest paid employee per department
* Department with highest average salary
* Salary range grouping

---

## How to Run

1. Clone the repository

```
git clone https://github.com/janardhan-akhil/java8-streams-coding.git
```

2. Open the project in **IntelliJ IDEA / Eclipse**

3. Run the `Main.java` class.

---

## Learning Outcomes

After completing this project you will understand:

* Functional programming in Java
* Stream API pipeline
* Intermediate vs Terminal operations
* Collectors framework
* Real-world Stream use cases

---

## Topics Covered

* Stream API
* Lambda Expressions
* Functional Interfaces
* Filtering
* Mapping
* Sorting
* Collectors
* Grouping
* Partitioning
* Reduce operations

---

## Author

**Akhil Janardhan**

Java Backend Developer
GitHub: https://github.com/janardhan-akhil

---

## Future Improvements

Planned additions:

* More interview-based stream problems
* Custom collectors
* Parallel streams examples
* Performance comparison examples

---
