package com.spring.employee.controller;

import com.spring.employee.employeeService.EmployeeService;
import com.spring.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/addemployee")
    public Employee addEmp(@RequestBody Employee e){
        return service.addEmployee(e);
    }
    @GetMapping("/get")
    public List<Employee> getAll(){
        return service.getAllemployee();
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getByhId(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmp(@RequestBody Employee e,@PathVariable("id") Long id){
        return service.updateEmployee(e,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleEmployee(@PathVariable("id") Long id){
        service.deleteEmployee(id);
    }
 }
