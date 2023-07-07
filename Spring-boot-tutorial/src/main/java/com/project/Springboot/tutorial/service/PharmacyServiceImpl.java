package com.project.Springboot.tutorial.service;
import com.project.Springboot.tutorial.entity.Pharmacy;
import com.project.Springboot.tutorial.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PharmacyServiceImpl implements PharmacyService{

    @Autowired
    private PharmacyRepository pharmacyRepository;

    //POST
    @Override
    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }
    //GET
    @Override
    public List<Pharmacy> fetchPharmacyList() {
        return pharmacyRepository.findAll();
    }
    //SEARCH BY ID
    @Override
    public Pharmacy fetchPharmacyById(Long id) {
        return pharmacyRepository.findById(id).get();
    }
    //SEARCH BY NAME
//    @Override
//    public Pharmacy fetchPharmacyByName(String medication_name) {
//        return pharmacyRepository.findByMedication_name(medication_name);
//    }
    //PUT or UPDATE
    @Override
    public Pharmacy updatePharmacy(Long id, Pharmacy pharmacy) {
    Pharmacy pharDb=pharmacyRepository.findById(id).get();

        if (Objects.nonNull(pharmacy.getDosage())&&
                !"".equalsIgnoreCase(pharmacy.getDosage())) {
            pharDb.setDosage(pharmacy.getDosage());
        }
        if (Objects.nonNull(pharmacy.getMedication_name())&&
        !"".equalsIgnoreCase(pharmacy.getMedication_name())){
            pharDb.setMedication_name(pharmacy.getMedication_name());
        }

        if (Objects.nonNull(pharmacy.getRefill_date())) {
            pharDb.setRefill_date(pharmacy.getRefill_date());
        }
        if (Objects.nonNull(pharmacy.getPrescription_number())) {
            pharDb.setPrescription_number(pharmacy.getPrescription_number());
        }
        if (Objects.nonNull(pharmacy.getPatient_id())) {
            pharDb.setPatient_id(pharmacy.getPatient_id());
         }

        return pharmacyRepository.save(pharDb);
    }
    //DELETE
    @Override
    public void deletePharmacyById(Long id) {
    pharmacyRepository.deleteById(id);
    }
}
