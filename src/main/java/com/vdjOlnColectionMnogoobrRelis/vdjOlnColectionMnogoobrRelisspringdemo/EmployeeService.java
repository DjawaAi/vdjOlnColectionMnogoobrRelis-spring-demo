package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeService {
    public final int maxNumber = 7;
    public Map<String, Employee> employees = new HashMap<>(Map.of());

    public Set<Map.Entry<String, Employee>> checkWords(String name, String secondName, int department, int salary) throws BadRequestException {
        if (StringUtils.isAlpha(name) && StringUtils.isAlpha(secondName)) {
            return employAdd(StringUtils.capitalize(name), StringUtils.capitalize(secondName), department, salary);
        } else {
            throw new BadRequestException("Есть не только буквы");
        }
    }

    public Set<Map.Entry<String, Employee>> employAdd(String name, String secondName, int department, int salary) {
        Employee employee = new Employee(name, secondName, department, salary);
        if (maxNumber > employees.size()) {
            if (employees.containsValue(employee)) {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAddedException");
            } else {
                employees.put((String.valueOf(name.charAt(0)) + secondName.charAt(0)), employee);
                return employees.entrySet();
            }
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    public Set<Map.Entry<String, Employee>> employRem(String name, String secondName, int department, int salary) {
        Employee employee = new Employee(name, secondName, department, salary);
        if (employees.containsValue(employee)) {
            employees.remove((name.charAt(0) + String.valueOf(secondName.charAt(0))), employee);
            return employees.entrySet();
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee employFind(String name, String secondName, int department, int salary) {
        Employee employee = new Employee(name, secondName, department, salary);
        if (employees.containsValue(employee) && employees.containsKey(name.charAt(0) + String.valueOf(secondName.charAt(0)))) {
            return employees.get(String.valueOf(name.charAt(0)) + secondName.charAt(0));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Set<Map.Entry<String, Employee>> allEmployees() {
        return employees.entrySet();
    }
}