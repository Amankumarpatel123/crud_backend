package com.project.Springboot.tutorial.repository;

import com.project.Springboot.tutorial.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Long> {
}
