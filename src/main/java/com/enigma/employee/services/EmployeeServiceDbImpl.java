package com.enigma.employee.services;

import com.enigma.employee.error.NotFoundException;
import com.enigma.employee.error.ResourceEmptyException;
import com.enigma.employee.models.Employee;
import com.enigma.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceDbImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeePage = repository.findAllByIsDeleteEquals(0);
        return employeePage;
    }

    @Override
    public Employee getById(String id) {
        if(repository.findById(id).isPresent()){
            Employee employee = repository.findById(id).get();
            return employee;
        } else throw new NotFoundException(id);
    }

    @Override
    public Employee insert(Employee employee) {
        if(employee.getBirthDate()!= null && employee.getGender()!=null && employee.getIdNumber()!=null &&
                            employee.getName()!=null && employee.getPosition().getId() != null){
            return repository.save(employee);
        } else throw new ResourceEmptyException();
    }

    @Override
    public Employee update(Employee employee) {
        if(employee.getBirthDate()!= null && employee.getGender()!=null && employee.getIdNumber()!=null &&
                employee.getName()!=null && employee.getPosition().getId() != null && employee.getId() != null){
            if (repository.findById(employee.getId()).isPresent()){
                return repository.save(employee);
            } else throw new NotFoundException(employee.getId());
        } else throw new ResourceEmptyException();
    }

    @Override
    public Employee delete(Employee employee) {
        if(employee.getId()!=null){
            employee.setDelete(1);
            return repository.save(employee);
        } else throw new ResourceEmptyException();
    }
}
