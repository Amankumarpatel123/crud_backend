package com.project.Springboot.tutorial.repository;

import com.project.Springboot.tutorial.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
}
