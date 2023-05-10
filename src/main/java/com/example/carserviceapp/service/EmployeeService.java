package com.example.carserviceapp.service;

import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        EmployeeModel employeeModel1 = EmployeeModel.builder()
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                .phoneNumber(employeeModel.getPhoneNumber())
                .email(employeeModel.getEmail())
                .build();
        employeeRepository.save(employeeModel1);
        return employeeModel1;
    }

    public EmployeeModel EditEmployee(long id, EmployeeModel employeeModel) {
        EmployeeModel employee1 = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        employee1.setName(employeeModel.getName());
        employee1.setSurname(employeeModel.getSurname());
        employee1.setPhoneNumber(employeeModel.getPhoneNumber());
        employee1.setEmail(employeeModel.getEmail());
        employee1 = employeeRepository.save(employee1);
        return employee1;

    }

    public EmployeeModel deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return null;
    }

    public EmployeeModel getEmployeeById(Long id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeRepository.findById(id).orElse(null);
        } else {
            log.info("nothing found");
            return null;
        }
    }

}