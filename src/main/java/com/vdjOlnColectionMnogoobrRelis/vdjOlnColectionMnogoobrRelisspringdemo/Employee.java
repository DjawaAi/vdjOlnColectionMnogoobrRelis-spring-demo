package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String secondName;
    private final int department;
    private final int salary;

    public Employee(String name, String secondName, int department, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, secondName, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", secondName='" + secondName + '\'' + ", department=" + department + ", salary=" + salary + '}';
    }
}

