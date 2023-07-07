package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAllStaff();
    Staff addStaff(Staff staff);
    Staff updateStaff(Long id, Staff staff);
    void deleteStaff(Long id);
}
