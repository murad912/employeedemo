package com.spring.employee.employeeService;

import com.spring.employee.model.Employee;
import com.spring.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;

    public Employee addEmployee(Employee e){
        return repo.save(e);
    }
    public List<Employee> getAllemployee(){
        return repo.findAll();
    }
    public Optional<Employee> getById(Long id){
        return repo.findById(id);
    }
    public Employee updateEmployee(Employee e, Long id){
       Optional<Employee> employee = repo.findById(id);
       if(!employee.isPresent()){
           return null;
       }else{
           e.getId(id);
           return repo.save(e);
       }
    }
    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
}
