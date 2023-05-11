package com.example.carserviceapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "number")
    private String number;

    @Column(name = "email")
    private String email;

    @Column(name = "document_number")
    private String document;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,mappedBy = "clientModel")
    private List<RepairModel> repairModel;
}
