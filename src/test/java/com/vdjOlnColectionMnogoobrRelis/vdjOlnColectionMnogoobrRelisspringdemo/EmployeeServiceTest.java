package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

class EmployeeServiceTest {

    EmployeeService employeeService = new EmployeeService();


    @Test
    void checkWords() {
        String name = "test";
        String secondName = "Test";
        assertThat(employeeService.allEmployees()).size().isEqualTo(0);
        var e = employeeService.checkWords(name, secondName, 1, 120);
        assertNotNull(e);
        assertEquals(1, e.size());
        assertThat(employeeService.allEmployees()).size().isEqualTo(1);
        var eM = e.iterator().next();
        assertEquals(StringUtils.capitalize("Test"), eM.getValue().getName());
        assertEquals(StringUtils.capitalize("Test"), eM.getValue().getSecondName());
        assertEquals(1, eM.getValue().getDepartment());
        assertEquals(120, eM.getValue().getSalary());
        assertEquals("TT", (String.valueOf(eM.getValue().getName().charAt(0)) + eM.getValue().getSecondName().charAt(0)));
        if (StringUtils.isAlpha("ddjj") && StringUtils.isAlpha("secondName")) {
            assertTrue(StringUtils.isAlpha("ddjj") && StringUtils.isAlpha("secondName"));
        } else {
            assertThrows(BadRequestException.class, () -> employeeService.checkWords("ddjj", "secondName", 2, 345));
        }

        if (StringUtils.isAlpha("ddj67j") && StringUtils.isAlpha("secondName")) {
            assertTrue(StringUtils.isAlpha("ddj67j") && StringUtils.isAlpha("secondName"));
        } else {
            assertThrows(BadRequestException.class, () -> employeeService.checkWords("ddj67j", "secondName", 2, 345));
        }

        if (StringUtils.isAlpha("ddjj") && StringUtils.isAlpha("secon%$dName")) {
            assertTrue(StringUtils.isAlpha("ddjj") && StringUtils.isAlpha("secon%$dName"));
        } else {
            assertThrows(BadRequestException.class, () -> employeeService.checkWords("ddjj", "secondN76ame", 2, 345));
        }

        if (StringUtils.isAlpha("dd%%jj") && StringUtils.isAlpha("secondN76ame")) {
            assertTrue(StringUtils.isAlpha("dd%%jj") && StringUtils.isAlpha("secondN76ame"));
        } else {
            assertThrows(BadRequestException.class, () -> employeeService.checkWords("dd%%jj", "secondN76ame", 2, 345));
        }
    }

    @Test
    void employAdd() {
        assertThat(employeeService.allEmployees()).size().isEqualTo(0);
        var e = employeeService.employAdd("At", "Zt", 1, 200);
        var e1 = employeeService.employAdd("St", "Xt", 1, 205);
        var e2 = employeeService.employAdd("Dt", "Ct", 1, 225);
        var e3 = employeeService.employAdd("Ft", "Vt", 2, 300);
        var e4 = employeeService.employAdd("Gt", "Bt", 2, 314);
        var e5 = employeeService.employAdd("Ht", "Nt", 2, 784);

        assertNotNull(e);
        assertEquals(6, e.size());
        assertThat(employeeService.allEmployees()).size().isEqualTo(6);
        var eM = e5.iterator().next();
        assertThat(employeeService.employees).size().isEqualTo(6);

        if (employeeService.employees.containsValue(eM.getValue())) {
            assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.employAdd("Ht", "Nt", 2, 784));
        }
        var e6 = employeeService.employAdd("Jt", "Mt", 3, 258);

        if (7 > e.size()) {
            assertFalse(e.contains(eM.getValue()));
        } else {
            assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.employAdd("Kt", "Lt", 3, 456));
        }
    }

    @Test
    void employRem() {
        assertThat(employeeService.allEmployees()).size().isEqualTo(0);
        var e = employeeService.employAdd("At", "Zt", 1, 200);
        var e1 = employeeService.employAdd("St", "Xt", 1, 205);
        var e2 = employeeService.employAdd("Dt", "Ct", 1, 225);
        var e3 = employeeService.employAdd("Ft", "Vt", 2, 300);
        var e4 = employeeService.employAdd("Gt", "Bt", 2, 314);
        var e5 = employeeService.employAdd("Ht", "Nt", 2, 784);

        assertNotNull(e);
        assertEquals(6, e.size());

        if (employeeService.employees.containsKey("GB")) {
            employeeService.employRem("Gt", "Bt", 2, 314);
            assertFalse(e.contains("GB"));
            assertEquals(5, e.size());
            for (var mE : e) {
                assertNotEquals("GB", mE.getKey());
            }
        }
        if (!(employeeService.employees.containsKey("GB"))) {
            assertThrows(EmployeeNotFoundException.class, () -> employeeService.employRem("Gt", "Bt", 2, 314));
        }
    }

    @Test
    void employFind() {
        assertThat(employeeService.allEmployees()).size().isEqualTo(0);
        employeeService.employAdd("At", "Zt", 1, 200);
        var e = employeeService.employFind("At", "Zt", 1, 200);
        assertNotNull(e);
        assertThat(employeeService.allEmployees().size()).isEqualTo(1);
        assertThat(e.getName()).isEqualTo("At");
        assertThat(e.getSecondName()).isEqualTo("Zt");
        assertThat(e.getDepartment()).isEqualTo(1);
        assertThat(e.getSalary()).isEqualTo(200);

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.employFind("Stk", "hti", 1, 200));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.employFind("Stk", "hti", 2, 254));
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.employFind("At", "Zt", 3, 254));

        Employee dF = new Employee("Fd", "We", 2, 456);
        boolean containsValue = employeeService.employees.containsValue(e);
        boolean containsKey = employeeService.employees.containsKey(e.getName().charAt(0) + String.valueOf(e.getSecondName().charAt(0)));
        assertTrue(containsValue);
        assertTrue(containsKey);

        boolean containsValue1 = employeeService.employees.containsValue(dF);
        boolean containsKey1 = employeeService.employees.containsKey(dF.getName().charAt(0) + String.valueOf(dF.getSecondName().charAt(0)));
        assertFalse(containsValue1);
        assertFalse(containsKey1);

        if (employeeService.employees.containsValue(e) && employeeService.employees.containsKey(dF.getName().charAt(0) + String.valueOf(dF.getSecondName().charAt(0)))){
            assertTrue(employeeService.employees.containsValue(e));
        } else {
            assertFalse((String.valueOf(dF.getName().charAt(0)) + String.valueOf(dF.getSecondName().charAt(0))).equals("AZ"));
            assertThrows(EmployeeNotFoundException.class, () -> employeeService.employFind("Fd", "We", 2, 456));
        }
    }

    @Test
    void allEmployees() {
    }
}