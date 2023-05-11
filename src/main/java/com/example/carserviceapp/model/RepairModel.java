package com.example.carserviceapp.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class RepairModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "issue")
    private String issue;


    @Column(name = "acceptancedate")
    private LocalDate acceptanceDate;
    @Column(name = "returndate")
    private LocalDate returnDate;

    @Column(name = "status")
    private String status;

    @Column(name = "fee")
    private String fee;

    @ManyToOne
    @JoinColumn(name = "clientModel_id")
    private ClientModel clientModel;

    @ManyToOne
    @JoinColumn(name = "employeeModel_id")
    private EmployeeModel employeeModel;
}
