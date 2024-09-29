package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewDepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private NewDepartmentService newDepartmentService;

    private Map<String, Employee> mockEmpl;
    private Set<Map.Entry<String, Employee>> mockEmplSetEnt;

    @BeforeEach
    void setUp() {
        mockEmpl = new HashMap<>();
        mockEmpl.put("GU", new Employee("Gena", "UbiSoft", 1, 500));
        mockEmpl.put("DR", new Employee("Dunya", "Ruman", 2, 605));
        mockEmpl.put("FE", new Employee("Feder", "Enoh", 1, 785));
        mockEmpl.put("MC", new Employee("Marfa", "Caient", 2, 508));
        mockEmplSetEnt = mockEmpl.entrySet();
    }

    @Test
    void allEmployeesOfDepartment() {
        int depId = 1;

        when(employeeService.allEmployees()).thenReturn(mockEmplSetEnt);

        Map<String, Employee> result = newDepartmentService.allEmployeesOfDepartment(depId);

        assertEquals(2, result.size());
        assertEquals("Gena", result.get("GU").getName());
        assertEquals("Feder", result.get("FE").getName());
    }

    @Test
    void returnsSumOfDepartmentSalary() {
        int depId = 2;

        when(employeeService.allEmployees()).thenReturn(mockEmplSetEnt);

        int result = newDepartmentService.returnsSumOfDepartmentSalary(depId);

        assertEquals(1113, result);
    }

    @Test
    void identifyEmployeeWithMaxZP() {
        int depId = 1;

        when(employeeService.allEmployees()).thenReturn(mockEmplSetEnt);

        Map.Entry<String, Employee> result = newDepartmentService.identifyEmployeeWithMaxZP(depId);

        assertEquals(785, result.getValue().getSalary());
        assertEquals("FE", result.getKey());
        assertEquals("Feder", result.getValue().getName());

        when(employeeService.allEmployees()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> newDepartmentService.identifyEmployeeWithMaxZP(depId));
    }

    @Test
    void identifyEmployeeWithMinZP() {
        int depId = 1;

        when(employeeService.allEmployees()).thenReturn(mockEmplSetEnt);

        Map.Entry<String, Employee> result = newDepartmentService.identifyEmployeeWithMinZP(depId);

        assertEquals(500, result.getValue().getSalary());
        assertEquals("GU", result.getKey());
        assertEquals("Gena", result.getValue().getName());

        when(employeeService.allEmployees()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> newDepartmentService.identifyEmployeeWithMinZP(depId));
    }

    @Test
    void allEmployeesByDepartment() {

        when(employeeService.allEmployees()).thenReturn(mockEmplSetEnt);

        Map<Integer, List<Employee>> result = newDepartmentService.allEmployeesByDepartment();

        assertEquals(2, result.size());
        assertEquals(2, result.get(1).size());
        assertEquals(2, result.get(2).size());

        List<Employee> department2Employees = result.get(2);
        assertEquals("Dunya", department2Employees.get(1).getName());
        assertEquals("Marfa", department2Employees.get(0).getName());

        when(employeeService.allEmployees()).thenReturn(null);

        assertThrows(NullPointerException.class, () -> newDepartmentService.allEmployeesByDepartment());
    }
}