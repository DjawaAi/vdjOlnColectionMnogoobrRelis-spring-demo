package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class NewDepartmentController {
    private final NewDepartmentService newDepartmentService;

    public NewDepartmentController(NewDepartmentService newDepartmentService) {
        this.newDepartmentService = newDepartmentService;
    }

    @GetMapping("/{id}/employees")
    public Map<String, Employee> allEmployeesOfDepartment(@PathVariable("id") int departID) {
        return newDepartmentService.allEmployeesOfDepartment(departID);
    }

    @GetMapping("/{id}/salary/sum")
    public int returnsSumOfDepartmentSalary(@PathVariable("id") int departID) {
        return newDepartmentService.returnsSumOfDepartmentSalary(departID);
    }

    @GetMapping("/{id}/salary/max")
    public Map.Entry<String, Employee> identifyEmployeeWithMaxZP(@PathVariable("id") int departID) {
        return newDepartmentService.identifyEmployeeWithMaxZP(departID);
    }

    @GetMapping("/{id}/salary/min")
    public Map.Entry<String, Employee> identifyEmployeeWithMinZP(@PathVariable("id") int departID) {
        return newDepartmentService.identifyEmployeeWithMinZP(departID);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return newDepartmentService.allEmployeesByDepartment();
    }
}
