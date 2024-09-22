package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewDepartmentService {

    private final EmployeeService employeeService;

    public NewDepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<String, Employee> allEmployeesOfDepartment(int departID) {
        return employeeService.allEmployees()
                .stream()
                .filter(e -> e.getValue().getDepartment() == departID)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public int returnsSumOfDepartmentSalary(int departID) {
        return employeeService.allEmployees()
                .stream()
                .filter(e -> e.getValue().getDepartment() == departID)
                .mapToInt(e -> e.getValue().getSalary())
                .sum();
    }

    public Map.Entry<String, Employee> identifyEmployeeWithMaxZP(int departID) {
        return employeeService.allEmployees()
                .stream()
                .filter(e -> e.getValue().getDepartment() == departID)
                .max(Comparator.comparingInt(e -> e.getValue().getSalary()))
                .orElseThrow(null);
    }

    public Map.Entry<String, Employee> identifyEmployeeWithMinZP(int departID) {
        return employeeService.allEmployees()
                .stream()
                .filter(e -> e.getValue().getDepartment() == departID)
                .min(Comparator.comparingInt(e -> e.getValue().getSalary()))
                .orElse(null);
    }

    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return employeeService.allEmployees()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
