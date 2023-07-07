package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.MedicalRecord;
import com.project.Springboot.tutorial.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Autowired
    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    @Override
    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    @Override
    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord) {
        MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(id).orElse(null);
        if (existingMedicalRecord != null) {
            existingMedicalRecord.setDate(medicalRecord.getDate());
            existingMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
            existingMedicalRecord.setPrescription(medicalRecord.getPrescription());
            existingMedicalRecord.setNotes(medicalRecord.getNotes());
            existingMedicalRecord.setDoctor_id(medicalRecord.getDoctor_id());
            existingMedicalRecord.setPatient_id(medicalRecord.getPatient_id());

            return medicalRecordRepository.save(existingMedicalRecord);
        }
        return null;
    }

    @Override
    public boolean deleteMedicalRecord(Long id) {
        if (medicalRecordRepository.existsById(id)) {
            medicalRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
