package com.example.carserviceapp.service;

import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.model.RepairModel;
import com.example.carserviceapp.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class RepairService {

    private final RepairRepository repairRepository;

    public List<RepairModel> getAllRepairs(){return repairRepository.findAll();}

    public void addRepair(RepairModel repairModel){
        repairRepository.save(repairModel);}

    public void SaveEditRepair(RepairModel repairModel){
        repairRepository.save(repairModel);}

    public void deleteRepair(Long id){
        repairRepository.deleteById(id);}

    public RepairModel getRepairsById(Long id) {
        Optional<RepairModel> repair = repairRepository.findById(id);
        if(repair.isPresent()){
            return repairRepository.findById(id).orElse(null);
        } else {
            log.info("nothing found");
            return null;
        }
    }
}
