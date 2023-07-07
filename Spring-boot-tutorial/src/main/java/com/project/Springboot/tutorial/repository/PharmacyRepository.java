package com.project.Springboot.tutorial.repository;
import com.project.Springboot.tutorial.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

//    Pharmacy findByMedication_name(String medication_name);
//
//    Pharmacy findByMedication_nameIgnoreCase(String medication_name);

}
