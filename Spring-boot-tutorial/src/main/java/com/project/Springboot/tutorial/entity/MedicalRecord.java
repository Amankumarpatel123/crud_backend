package com.project.Springboot.tutorial.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String diagnosis;
    private String prescription;
    private String notes;
    private Long doctor_id;
    private Long patient_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public MedicalRecord(Long id, LocalDate date, String diagnosis, String prescription, String notes, Long doctor_id, Long patient_id) {
        this.id = id;
        this.date = date;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", date=" + date +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", notes='" + notes + '\'' +
                ", doctor_id=" + doctor_id +
                ", patient_id=" + patient_id +
                '}';
    }

    public MedicalRecord() {
    }
}
