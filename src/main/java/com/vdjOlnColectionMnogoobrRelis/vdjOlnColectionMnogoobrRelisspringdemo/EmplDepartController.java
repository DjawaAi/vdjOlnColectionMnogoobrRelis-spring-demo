package com.vdjOlnColectionMnogoobrRelis.vdjOlnColectionMnogoobrRelisspringdemo;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmplDepartController {
    private final EmplDepartService emplDepartService;

    public EmplDepartController(EmplDepartService emplDepartService) {
        this.emplDepartService = emplDepartService;
    }
}