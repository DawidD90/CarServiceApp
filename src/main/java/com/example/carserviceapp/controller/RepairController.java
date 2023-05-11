package com.example.carserviceapp.controller;

import com.example.carserviceapp.model.EmployeeModel;
import com.example.carserviceapp.model.RepairModel;
import com.example.carserviceapp.service.EmployeeService;
import com.example.carserviceapp.service.RepairService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/repair")
public class RepairController {

    private final RepairService repairService;

    //getting a list of all repairs
    @GetMapping("/")
    public List<RepairModel> getAllRepairs() {
        return repairService.getAllRepairs();
    }

    //finding repairs by id
    @GetMapping("/{id}")
    public RepairModel getRepairById(@PathVariable("id") long id) {return repairService.getRepairsById(id);
    }

    //adding a new repair
    @PostMapping("/")
    public RepairModel addRepair(@RequestBody RepairModel repair) {

        return repairService.addRepair(repair) ;
    }

    //editing repair details
    @PatchMapping("/{id}")
    public RepairModel EditRepair(@PathVariable long id, @RequestBody RepairModel repairmodel) {
        return repairService.EditRepair(id, repairmodel);
    }

    //deletion of the repair
    @DeleteMapping("/{id}")
    public RepairModel deleteRepair(@PathVariable("id") long id) {return repairService.deleteRepair(id);
    }




}
