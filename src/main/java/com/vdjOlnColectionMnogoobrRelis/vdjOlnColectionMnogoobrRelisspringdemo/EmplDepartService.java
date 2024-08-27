package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmplDepartService {
    private final EmployeeService employeeService;

    public EmplDepartService(EmployeeService employeeService) {
        this.employeeService = employeeService;
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

    public Map<String, Employee> allEmployeesOfDepartment(int departID) {
        return employeeService.allEmployees()
                .stream()
                .filter(e -> e.getValue().getDepartment() == departID)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return employeeService.allEmployees()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}