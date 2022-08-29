package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);

    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee inputEmployee){
        Employee employee = this.employeeRepository.findById(id).get();
        employee.setFirstName(inputEmployee.getFirstName());
        employee.setLastName(inputEmployee.getLastName());
        employee.setEmailId(inputEmployee.getEmailId());
        employee.setTitle(inputEmployee.getTitle());
        employee.setPhoneNumber(inputEmployee.getPhoneNumber());
        return  this.employeeRepository.save(employee);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        this.employeeRepository.deleteById(id);
    }


}
