package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient updatePatient(Patient patient);
    boolean deletePatient(Long id);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
}

