package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Staff;
import com.project.Springboot.tutorial.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    private  final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        Staff existingStaff = staffRepository.findById(id).orElse(null);
        if (existingStaff != null) {
            existingStaff.setName(staff.getName());
            existingStaff.setAge(staff.getAge());
            existingStaff.setGender(staff.getGender());
            existingStaff.setAddress(staff.getAddress());
            existingStaff.setPhone(staff.getPhone());
            existingStaff.setJobTitle(staff.getJobTitle());
            existingStaff.setEmail(staff.getEmail());
            existingStaff.setSalary(staff.getSalary());
            existingStaff.setBenefits(staff.getBenefits());

            return staffRepository.save(existingStaff);
        }
        return null;
    }

    @Override
    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}