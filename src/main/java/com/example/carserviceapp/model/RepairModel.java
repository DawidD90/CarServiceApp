package com.example.carserviceapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

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
