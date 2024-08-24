package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Set<Map.Entry<String, Employee>> employAdd(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String secondName,
                                                      @RequestParam int department, @RequestParam int salary) {
        return employeeService.employAdd(name, secondName, department, salary);
    }


    @GetMapping(path = "/remove")
    public Set<Map.Entry<String, Employee>> employRem(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String secondName,
                                                      @RequestParam int department, @RequestParam int salary) {
        return employeeService.employRem(name, secondName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee employFind(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String secondName,
                               @RequestParam int department, @RequestParam int salary) {
        return employeeService.employFind(name, secondName, department, salary);
    }
}
