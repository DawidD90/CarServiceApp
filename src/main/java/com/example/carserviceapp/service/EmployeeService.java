package com.example.carserviceapp.service;

import com.example.carserviceapp.model.EmployeeDetails;
import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<EmployeeModel> employeeModel = employeeRepository.findByUserName(userName);
        employeeModel.orElseThrow(()-> new UsernameNotFoundException("Not found user with username: " + userName));

        return employeeModel.map(EmployeeDetails::new).get();
    }

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        EmployeeModel employeeModel1 = EmployeeModel.builder()
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                .phoneNumber(employeeModel.getPhoneNumber())
                .userName(employeeModel.getUserName())
                .password(employeeModel.getPassword())
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
        employee1.setUserName(employeeModel.getUserName());
        employee1.setRole(employeeModel.getRole());
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