package com.example.carserviceapp.repository;

import com.example.carserviceapp.model.RepairModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<RepairModel,Long> {

    Page<RepairModel> findAllBy(Pageable pageable);
}
