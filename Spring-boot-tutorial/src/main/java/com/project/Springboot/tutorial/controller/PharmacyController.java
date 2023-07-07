package com.project.Springboot.tutorial.controller;
import com.project.Springboot.tutorial.entity.Pharmacy;
import com.project.Springboot.tutorial.service.PharmacyService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    private final Logger LOGGER= LoggerFactory.getLogger(PharmacyController.class); //default Logger slf4j is used
    //a Logger is a utility used in software development to record important information, warnings, errors,
    // and debug messages during the execution of an application. It helps with debugging, troubleshooting, monitoring, auditing, tracking application flow, collaboration, communication, and performance analysis.


    @PostMapping ("/pharmacy")
    public Pharmacy savePharmacy(@Valid @RequestBody Pharmacy pharmacy)
    {
        LOGGER.info("Inside savePharmacy of PharmacyController.");
        return pharmacyService.savePharmacy(pharmacy);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/pharmacy")
    public List<Pharmacy> fetchPharmacyList()
    {
        LOGGER.info("Inside fetchPharmacyList of PharmacyController.");
        return pharmacyService.fetchPharmacyList();
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/pharmacy/{id}")     //getting the specific element by Id here id path variable ginven to id
    public Pharmacy fetchPharmacyById(@PathVariable("id") Long id){
        return pharmacyService.fetchPharmacyById(id);
    }

    @DeleteMapping("/pharmacy/{id}")
    public  String deletePharmacyById(@PathVariable("id")Long id) {
        pharmacyService.deletePharmacyById(id);
        return "Deleted";
    }

    @PutMapping("/pharmacy/{id}")
    public Pharmacy updatePharmacy(@PathVariable("id")Long id, @RequestBody Pharmacy pharmacy){
        return pharmacyService.updatePharmacy(id, pharmacy);
    }

//    @GetMapping("/pharmacy/name/{name}")
//    public Pharmacy fetchPharmacyByName(@PathVariable("name")String medication_name){
//        return pharmacyService.fetchPharmacyByName(medication_name);
    }


