package com.example.carserviceapp.service;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<EmployeeModel> getAllEmployees(){return employeeRepository.findAll();}

    public void addEmployee(EmployeeModel employeeModel){
        employeeRepository.save(employeeModel);}

    public void SaveEditClient(EmployeeModel employeeModel){
        employeeRepository.save(employeeModel);}

    public void deleteClient(Long id){
        employeeRepository.deleteById(id);}

    public EmployeeModel getEmployeeById(Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employeeRepository.findById(id).orElse(null);
        } else {
            log.info("nothing found");
            return null;
        }
    }

}