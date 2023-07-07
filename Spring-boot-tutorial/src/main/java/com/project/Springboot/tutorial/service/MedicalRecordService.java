package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    List<MedicalRecord> getAllMedicalRecords();
    MedicalRecord getMedicalRecordById(Long id);
    MedicalRecord addMedicalRecord(MedicalRecord medicalRecord);
    MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord);
    boolean deleteMedicalRecord(Long id);
}
