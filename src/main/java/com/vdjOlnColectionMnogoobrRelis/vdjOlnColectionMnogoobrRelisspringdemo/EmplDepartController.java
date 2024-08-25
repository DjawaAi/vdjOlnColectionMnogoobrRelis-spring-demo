package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class EmplDepartController {
    private final EmplDepartService emplDepartService;

    public EmplDepartController(EmplDepartService emplDepartService) {
        this.emplDepartService = emplDepartService;
    }

    @GetMapping(path = "max-salary")
    public Map.Entry<String, Employee> identifyEmployeeWithMaxZP(@RequestParam int departID) {
        return emplDepartService.identifyEmployeeWithMaxZP(departID);
    }

    @GetMapping(path = "/min-salary")
    public Map.Entry<String, Employee> identifyEmployeeWithMinZP(@RequestParam int departID) {
        return emplDepartService.identifyEmployeeWithMinZP(departID);
    }

    @GetMapping(path = "/allOfDep")
    public Map<String, Employee> allEmployeesOfDepartment(@RequestParam int departID) {
        return emplDepartService.allEmployeesOfDepartment(departID);
    }

    @GetMapping(path = "all")
    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return emplDepartService.allEmployeesByDepartment();
    }
}