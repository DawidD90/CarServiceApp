package com.example.carserviceapp.repository;

import com.example.carserviceapp.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Long> {

//        Page<ClientModel> findAllBy(Pageable pageable);
}
