package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
     Pharmacy savePharmacy(Pharmacy pharmacy);

     List<Pharmacy> fetchPharmacyList();

    Pharmacy fetchPharmacyById(Long id);

//    Pharmacy fetchPharmacyByName(String medication_name);
    Pharmacy updatePharmacy(Long id, Pharmacy pharmacy);

    void deletePharmacyById(Long id);

}

