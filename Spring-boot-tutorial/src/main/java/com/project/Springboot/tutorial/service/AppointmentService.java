package com.project.Springboot.tutorial.service;

import com.project.Springboot.tutorial.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    List<Appointment>getAllAppointments();
    List<Appointment>getAppointmentsByDoctorId(Long doctorId);
    List<Appointment>getAppointmentsByPatientId(Long patientId);

    boolean deleteAllAppointments();
}
