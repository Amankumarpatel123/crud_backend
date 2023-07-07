package com.project.Springboot.tutorial.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    private String treatment_descrption;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTreatment_descrption() {
        return treatment_descrption;
    }

    public void setTreatment_descrption(String treatment_descrption) {
        this.treatment_descrption = treatment_descrption;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public Billing(Long id, LocalDate date, double amount, String treatment_descrption, Long patient_id) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.treatment_descrption = treatment_descrption;
        this.patient_id = patient_id;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", treatment_descrption='" + treatment_descrption + '\'' +
                ", patient_id=" + patient_id +
                '}';
    }

    public Billing() {
    }
}
