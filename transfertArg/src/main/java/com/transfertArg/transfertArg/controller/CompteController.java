
package com.transfertArg.transfertArg.controller;

import com.transfertArg.transfertArg.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;

    }

