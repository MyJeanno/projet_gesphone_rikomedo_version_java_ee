package com.phone.Gesphone.controller;

import com.phone.Gesphone.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ApproController {
    @Autowired
    private ProduitService produitService;


}
