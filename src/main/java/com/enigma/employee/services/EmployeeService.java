package com.enigma.employee.services;

import com.enigma.employee.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList ();
    Employee getById(String id);
    Employee insert(Employee employee);
    Employee update(Employee employee);
    Employee delete(Employee employee);
}
