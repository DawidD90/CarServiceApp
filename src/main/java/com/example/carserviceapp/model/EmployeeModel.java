package com.example.carserviceapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,mappedBy = "employeeModel")
    private List<RepairModel> repairModel;









}
