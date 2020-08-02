package com.enigma.employee.repositories;

import com.enigma.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    List<Employee> findAllByIsDeleteEquals(Integer code);
}
