package com.example.carserviceapp.repository;

import com.example.carserviceapp.model.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long> {

    Page<EmployeeModel> findAllBy(Pageable pageable);

}
