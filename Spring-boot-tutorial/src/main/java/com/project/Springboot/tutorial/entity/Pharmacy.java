package com.project.Springboot.tutorial.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;
@Entity
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please enter the medication name!")
    @NotBlank(message = "medication name can't be empty!")
    @Length(max = 35, min = 1, message = "length out of range")     // to limit the range of medication name
    private String medication_name;

    @NotBlank
    private String dosage;



    private LocalDate refill_date;


    private Long prescription_number;


    private Long patient_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedication_name() {
        return medication_name;
    }

    public void setMedication_name(String medication_name) {
        this.medication_name = medication_name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public LocalDate getRefill_date() {
        return refill_date;
    }

    public void setRefill_date(LocalDate refill_date) {
        this.refill_date = refill_date;
    }

    public Long getPrescription_number() {
        return prescription_number;
    }

    public void setPrescription_number(Long prescription_number) {
        this.prescription_number = prescription_number;
    }

    public Long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
    }

    public Pharmacy(Long id, String medication_name, String dosage, LocalDate refill_date, Long prescription_number, Long patient_id) {
        this.id = id;
        this.medication_name = medication_name;
        this.dosage = dosage;
        this.refill_date = refill_date;
        this.prescription_number = prescription_number;
        this.patient_id = patient_id;

    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", medication_name='" + medication_name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", refill_date=" + refill_date +
                ", prescription_number=" + prescription_number +
                ", patient_id=" + patient_id +
                '}';

    }

    public Pharmacy() {
    }
}
