package com.example.carserviceapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    @DateTimeFormat(pattern= "dd-MM-yyyy")
    private Date acceptanceDate;
    @Column(name = "returndate")
    @DateTimeFormat(pattern= "dd-MM-yyyy")
    private Date returnDate;

    @Column(name = "status")
    private String status;

    @Column(name = "fee")
    private String fee;


}
