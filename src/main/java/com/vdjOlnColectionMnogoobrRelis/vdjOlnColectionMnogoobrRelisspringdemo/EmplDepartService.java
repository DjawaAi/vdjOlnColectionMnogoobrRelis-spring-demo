package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.springframework.stereotype.Service;

@Service
public class EmplDepartService {
    private final EmployeeService employeeService;

    public EmplDepartService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static int identifyEmployeeWithMinZP(Employee[] employee) {
        int absoluteMinimum = 1_000_000;
        int idEmployeeMinZP = 0;
        for (Employee value : employee) {
            if (value.getSalary() < absoluteMinimum) {
                absoluteMinimum = value.getSalary();
                idEmployeeMinZP = value.getId();
            }
        }
        return idEmployeeMinZP;
    }

    public static int identifyEmployeeWithMaxZP(Employee[] employee) {
        int absoluteMax = 1_000;
        int idEmployeeMaxZP = 0;
        for (Employee value : employee) {
            if (value.getSalary() > absoluteMax) {
                absoluteMax = value.getSalary();
                idEmployeeMaxZP = value.getId();
            }
        }
        return idEmployeeMaxZP;
    }

    public static void printDataOfAllEmployees(Employee[] employee ) {
        for (Employee value : employee) {
            System.out.println(value);
        }
    }

}
