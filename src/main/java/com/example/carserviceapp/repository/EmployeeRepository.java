package com.example.carserviceapp.repository;

import com.example.carserviceapp.model.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {

    Optional<EmployeeModel> findByUserName(String userName);

    Page<EmployeeModel> findAllBy(Pageable pageable);

}
