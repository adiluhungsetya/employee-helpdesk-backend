package com.enigma.employee.controller;

import com.enigma.employee.models.Employee;
import com.enigma.employee.models.Position;
import com.enigma.employee.services.EmployeeService;
import com.enigma.employee.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mst")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @Autowired
    PositionService positionService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.insert(employee);
    }

    @PutMapping
    public Employee editEmployee(@RequestBody Employee employee){
        return service.update(employee);
    }

    @DeleteMapping
    public Employee deleteEmployee(@RequestBody Employee employee){
        return service.delete(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return service.getEmployeeList();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return service.getById(id);
    }

    @GetMapping("/position")
    public List<Position> getAllPosition(){
        return positionService.getPositionList();
    }

    @PostMapping("/position")
    public Position savePosition(@RequestBody Position position){
        return positionService.insert(position);
    }
}