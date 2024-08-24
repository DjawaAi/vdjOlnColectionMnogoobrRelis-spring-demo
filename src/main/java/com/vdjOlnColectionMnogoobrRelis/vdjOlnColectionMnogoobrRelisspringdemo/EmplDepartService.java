package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

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

//    public static int identifyEmployeeWithMinZP(Employee[] employee) {
//        int absoluteMinimum = 1_000_000;
//        int idEmployeeMinZP = 0;
//        for (Employee value : employee) {
//            if (value.getSalary() < absoluteMinimum) {
//                absoluteMinimum = value.getSalary();
//                idEmployeeMinZP = value.getId();
//            }
//        }
//        return idEmployeeMinZP;
//    }
//
//    public static void printDataOfAllEmployees(Employee[] employee ) {
//        for (Employee value : employee) {
//            System.out.println(value);
//        }
//    }

}
