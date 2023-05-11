package com.example.carserviceapp.service;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.model.RepairModel;
import com.example.carserviceapp.repository.RepairRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class RepairService {

    private final RepairRepository repairRepository;

    public List<RepairModel> getAllRepairs(){return repairRepository.findAll();}

    public RepairModel addRepair(RepairModel repairModel){
        RepairModel repair1 = repairModel.builder()
                .make(repairModel.getMake())
                .model(repairModel.getModel())
                .issue(repairModel.getIssue())
                .acceptanceDate(repairModel.getAcceptanceDate())
                .returnDate(repairModel.getReturnDate())
                .status(repairModel.getStatus())
                .fee(repairModel.getFee())
                .build();
        repairRepository.save(repair1);
    return repair1;
    }

    public RepairModel EditRepair(long id,RepairModel repairModel) {
        RepairModel modelNew = repairRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
        modelNew.setMake(repairModel.getMake());
        modelNew.setModel(repairModel.getModel());
        modelNew.setIssue(repairModel.getIssue());
        modelNew.setAcceptanceDate(repairModel.getAcceptanceDate());
        modelNew.setReturnDate(repairModel.getReturnDate());
        modelNew.setStatus(repairModel.getStatus());
        modelNew.setFee(repairModel.getFee());
        modelNew = repairRepository.save(modelNew);
        return modelNew;
    }

    public RepairModel deleteRepair(Long id){
        repairRepository.deleteById(id);
    return null;
    }

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
