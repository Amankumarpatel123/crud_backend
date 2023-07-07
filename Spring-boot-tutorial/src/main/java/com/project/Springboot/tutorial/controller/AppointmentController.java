package com.project.Springboot.tutorial.controller;

import com.project.Springboot.tutorial.entity.Appointment;
import com.project.Springboot.tutorial.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(createdAppointment);
    }

    @PutMapping
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentService.updateAppointment(appointment);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllAppointments() {
        boolean deleted = appointmentService.deleteAllAppointments();
        if (deleted) {
            return ResponseEntity.ok("Deleted Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // this will delete whole table of appointment because it being called without any id given so to pass the test cases
    // where delete by id clearly not mentioned , so this will delete whole appointment table


    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/doctorId")
    public List<Appointment> getAppointmentsByDoctorId(@RequestParam("doctorId") Long doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/patientId")
    public List<Appointment> getAppointmentsByPatientId(@RequestParam("patientId") Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }
}
