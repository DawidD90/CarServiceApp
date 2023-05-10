package com.example.carserviceapp.controller;

import com.example.carserviceapp.model.ClientModel;
import com.example.carserviceapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;



}

