package com.project.Springboot.tutorial.controller;

import com.project.Springboot.tutorial.entity.MedicalRecord;
import com.project.Springboot.tutorial.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {


    private final MedicalRecordService medicalRecordService;

    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordService.getAllMedicalRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable("id") Long id) {
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordById(id);
        if (medicalRecord != null) {
            return ResponseEntity.ok(medicalRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        MedicalRecord createdMedicalRecord = medicalRecordService.addMedicalRecord(medicalRecord);
        return ResponseEntity.ok(createdMedicalRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable("id") Long id, @RequestBody MedicalRecord medicalRecord) {
        MedicalRecord updatedMedicalRecord = medicalRecordService.updateMedicalRecord(id, medicalRecord);
        if (updatedMedicalRecord != null) {
            return ResponseEntity.ok(updatedMedicalRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable("id") Long id) {
        boolean deleted = medicalRecordService.deleteMedicalRecord(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}