package com.example.carserviceapp.controller;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController{

        private final EmployeeService employeeService;

    //getting a list of all employees
    @GetMapping("/")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //finding the client by id
    @GetMapping("/{id}")
    public EmployeeModel getEmployeeById(@PathVariable("id") long id) {
        return employeeService.getEmployeeById(id);
    }

    //adding a new employee
    @PostMapping("/")
    public EmployeeModel addEmployee(@RequestBody EmployeeModel employee) {
        return employeeService.addEmployee(employee);
    }

    //editing employee's details
    @PatchMapping("/{id}")
    public EmployeeModel EditEmployee(@PathVariable long id, @RequestBody EmployeeModel employeemodel) {
        return employeeService.EditEmployee(id, employeemodel);
    }

    //deletion of the employee
    @DeleteMapping("/{id}")
    public EmployeeModel removeEmployee(@PathVariable("id") long id) {
        return employeeService.deleteEmployee(id);
    }




}
